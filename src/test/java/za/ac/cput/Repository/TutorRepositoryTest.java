package za.ac.cput.repository;
/*  TutorRepositoryTest.java
    Tutor repository test class
    Author: Angelo Kane Smidt (230688020)
    Date: 28 March 2025
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Tutor;
import za.ac.cput.factory.TutorFactory;

@TestMethodOrder(MethodOrderer.MethodName.class)
class TutorRepositoryTest {
    private static TutorRepository repo = TutorRepository.getRepo();
    private static Tutor tutor = TutorFactory.createTutor("James", "Bond", "bondj@gmail.com", "0232415678", "None");

    @Test
    void a_create() {
        Tutor created = repo.create(tutor);
        assertEquals(tutor.getTutorId(), created.getTutorId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Tutor read = repo.read(tutor.getTutorId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        // Create a new Tutor with updated number but same ID
        Tutor updated = new Tutor.TutorBuilder()
                .tutorId(tutor.getTutorId())
                .tutorName(tutor.getTutorName())
                .tutorSurname(tutor.getTutorSurname())
                .tutorEmail(tutor.getTutorEmail())
                .tutorPhoneNumber("0875321234")
                .qualifications(tutor.getQualifications())
                .build();

        assertNotNull(repo.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete() {
        boolean success = repo.delete(tutor.getTutorId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all:");
        System.out.println(repo.getAll());
    }
}
