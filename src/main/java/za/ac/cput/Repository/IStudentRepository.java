package za.ac.cput.Repository;

import za.ac.cput.domain.Student;

import java.util.List;
/**
 * IStudentRepository.java
 * Repository interface for Student
 * Author: [Cameron Savage] ([230582567])
 * Date: [25/03/2025]
 */

public interface IStudentRepository extends IRepository <Student, String> {
    List<Student> getAll();
}
