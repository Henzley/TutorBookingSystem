package za.ac.cput.repository;

import za.ac.cput.domain.Subject;

import java.util.List;

public interface ISubjectRepository extends IRepository<Subject, String> {
    List<Subject> getAll();
}
