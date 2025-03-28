package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Student;
import za.ac.cput.Factory.StudentFactory;
import static org.junit.jupiter.api.Assertions.*;

/**
 * StudentRepositoryTest.java
 * Test for StudentRepository
 * Author: [Cameron Savage] ([230582567])
 * Date: [27/03/25]
 */
//TestMethodOrder used to ensure CRUD test follows the proper sequence
@TestMethodOrder(MethodOrderer.MethodName.class)
class StudentRepositoryTest {
    private static StudentRepository repository = StudentRepository.getRepository();
    private static Student student = StudentFactory.createStudent(
            "Jonas", "Doysus", "jonkles12@cput.ac.za",
            "0831234567", "230582566", "ADP"
    );

    @Test
    void a_create() {
        Student created = repository.create(student);
        assertEquals(student.getStudentId(), created.getStudentId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Student read = repository.read(student.getStudentId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        // Create a new Student with updated name but same ID
        Student updated = new Student.Builder()
                .studentId(student.getStudentId()) // Keep same ID
                .name("Johnathan") // Updated name
                .surname(student.getSurname())
                .email(student.getEmail())
                .phone(student.getPhone())
                .studentNumber(student.getStudentNumber())
                .course(student.getCourse())
                .build();

        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(student.getStudentId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }
}