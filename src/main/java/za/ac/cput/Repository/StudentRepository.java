package za.ac.cput.Repository;

import za.ac.cput.domain.Student;
import za.ac.cput.Repository.IStudentRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * StudentRepository.java
 * Implementation of StudentRepository
 * Author: [Cameron Savage] ([230582567])
 * Date: [25/03/2025]
 */
public class StudentRepository implements IStudentRepository {
    private static StudentRepository repository = null;
    // private Set<Student> studentDB;
    private List<Student> studentDB;

    /* private StudentRepository() {
         studentDB = new HashSet<>();
     }
 */
    private StudentRepository(){
        studentDB = new ArrayList<Student>();
    }

    public static StudentRepository getRepository() {
        if (repository == null) {
            repository = new StudentRepository();
        }
        return repository;
    }

    @Override
    public Student create(Student student) {
        studentDB.add(student);
        return student;
    }

    @Override
    public Student read(String studentId) {
        return studentDB.stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .findAny()
                .orElse(null);
    }

    @Override
    public Student update(Student student) {
        Student oldStudent = read(student.getStudentId());
        if (oldStudent != null) {
            studentDB.remove(oldStudent);
            studentDB.add(student);
            return student;
        }
        return null;
    }

    @Override
    public boolean delete(String studentId) {
        Student student = read(studentId);
        if (student != null) {
            studentDB.remove(student);
            return true;
        }
        return false;
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(studentDB);
    }

   /* @Override
    public Set<Student> getStudentsByCourse(String course) {
        Set<Student> studentsByCourse = new HashSet<>();
        for (Student student : studentDB) {
            if (student.getCourse().equalsIgnoreCase(course)) {
                studentsByCourse.add(student);
            }
        }
        return studentsByCourse;
    }

*/
}