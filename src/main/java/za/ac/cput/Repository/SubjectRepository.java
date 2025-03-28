package za.ac.cput.repository;

import za.ac.cput.domain.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectRepository implements ISubjectRepository {
    private static SubjectRepository repository = null;
    private List<Subject> subjectsList;

    private SubjectRepository() {
        subjectsList = new ArrayList<>();
    }

    public static SubjectRepository getInstance() {
        if (repository == null) {
            repository = new SubjectRepository();
        }
        return repository;
    }

    @Override
    public List<Subject> getAll() {
        return new ArrayList<>(subjectsList);
    }

    @Override
    public Subject create(Subject subject) {
        if (subject == null) {
            return null;
        }

        // Check if subject already exists to avoid duplicates
        if (read(subject.getSubjectName()) == null) {
            subjectsList.add(subject);
            return subject;
        }

        return null;
    }

    @Override
    public Subject read(String subjectName) {
        return subjectsList.stream()
                .filter(subject -> subject.getSubjectName().equalsIgnoreCase(subjectName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Subject update(Subject subject) {
        if (subject == null) {
            return null;
        }

        // Find existing subject
        Subject existingSubject = read(subject.getSubjectName());

        if (existingSubject != null) {
            // Remove old subject
            subjectsList.remove(existingSubject);
            // Add updated subject
            subjectsList.add(subject);
            return subject;
        }

        return null;
    }

    @Override
    public boolean delete(String subjectName) {
        return subjectsList.removeIf(
                s -> s.getSubjectName().equalsIgnoreCase(subjectName)
        );
    }
}