package za.ac.cput.repository;

import za.ac.cput.domain.Session;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SessionRepositoryTest {
    private SessionRepository sessionRepository;
    private Session session1;
    private Session session2;
    private Student testStudent;
    private Subject testSubject;

    @BeforeEach
    void setUp() {
        // Reset the singleton instance before each test
        sessionRepository = SessionRepository.getInstance();

        // Create a test student
        testStudent = new Student.Builder()
                .studentId("ST001")
                .name("John")
                .surname("Doe")
                .email("john.doe@example.com")
                .build();

        // Create a test subject
        testSubject = new Subject.Builder()
                .setSubjectId("MAT101")
                .setSubjectName("Mathematics")
                .build();

        // Create test sessions
        session1 = new Session.Builder()
                .sessionID("SES001")
                .bookingID("BOOK001")
                .tutorID("TUT001")
                .student(testStudent)
                .sessionStart("2024-03-28 10:00")
                .sessionEnd("2024-03-28 11:00")
                .sessionStatus("Scheduled")
                .location("Study Room A")
                .sessionSubject(testSubject)
                .build();

        session2 = new Session.Builder()
                .sessionID("SES002")
                .bookingID("BOOK002")
                .tutorID("TUT002")
                .student(testStudent)
                .sessionStart("2024-03-29 14:00")
                .sessionEnd("2024-03-29 15:00")
                .sessionStatus("Completed")
                .location("Online")
                .sessionSubject(testSubject)
                .build();
    }

    @Test
    void testGetInstance() {
        SessionRepository secondInstance = SessionRepository.getInstance();
        assertSame(sessionRepository, secondInstance,
                "getInstance() should return the same instance");
    }

    @Test
    void testCreate() {
        // Test creating a new session
        Session createdSession = sessionRepository.create(session1);
        assertNotNull(createdSession, "Create should return the created session");
        assertEquals(session1, createdSession, "Created session should match input");

        // Verify the session is added to the repository
        Session foundSession = sessionRepository.read(session1.getSessionID());
        assertNotNull(foundSession, "Created session should be readable");
        assertEquals(session1, foundSession, "Created session should match the input");
    }

    @Test
    void testRead() {
        // First create a session
        sessionRepository.create(session1);

        // Test reading an existing session
        Session foundSession = sessionRepository.read(session1.getSessionID());
        assertNotNull(foundSession, "Read should find an existing session");
        assertEquals(session1, foundSession, "Read should return the correct session");

        // Test reading a non-existing session
        Session nonExistentSession = sessionRepository.read("NON_EXISTENT_ID");
        assertNull(nonExistentSession, "Read should return null for non-existent session");
    }

    @Test
    void testUpdate() {
        // Create initial session
        sessionRepository.create(session1);

        // Create an updated version of the session
        Session updatedSession = new Session.Builder()
                .sessionID(session1.getSessionID())
                .bookingID(session1.getBookingID())
                .tutorID(session1.getTutorID())
                .student(session1.getStudent())
                .sessionStart(session1.getSessionStart())
                .sessionEnd(session1.getSessionEnd())
                .sessionStatus("Cancelled")  // Changed status
                .location(session1.getLocation())
                .sessionSubject(session1.getSessionSubject())
                .build();

        // Perform update
        Session resultSession = sessionRepository.update(updatedSession);
        assertNotNull(resultSession, "Update should return the updated session");
        assertEquals("Cancelled", resultSession.getSessionStatus(), "Session status should be updated");

        // Verify the update in the repository
        Session foundSession = sessionRepository.read(session1.getSessionID());
        assertEquals("Cancelled", foundSession.getSessionStatus(), "Repository should reflect the updated session");

        // Test updating a non-existent session
        Session nonExistentSession = new Session.Builder()
                .sessionID("NON_EXISTENT_ID")
                .bookingID("BOOK999")
                .tutorID("TUT999")
                .student(testStudent)
                .sessionStart("2024-04-01 10:00")
                .sessionEnd("2024-04-01 11:00")
                .sessionStatus("Scheduled")
                .location("Test Location")
                .sessionSubject(testSubject)
                .build();

        Session failedUpdate = sessionRepository.update(nonExistentSession);
        assertNull(failedUpdate, "Updating a non-existent session should return null");
    }

    @Test
    void testDelete() {
        // Create a session to delete
        sessionRepository.create(session1);

        // Test successful deletion
        boolean deleteResult = sessionRepository.delete(session1.getSessionID());
        assertTrue(deleteResult, "Delete should return true for an existing session");

        // Verify the session is actually deleted
        Session deletedSession = sessionRepository.read(session1.getSessionID());
        assertNull(deletedSession, "Session should be removed after deletion");

        // Test deleting a non-existent session
        boolean deleteNonExistent = sessionRepository.delete("NON_EXISTENT_ID");
        assertFalse(deleteNonExistent, "Delete should return false for a non-existent session");
    }

    @Test
    void testGetAll() {
        // Create multiple sessions
        sessionRepository.create(session1);
        sessionRepository.create(session2);

        // Get all sessions
        var allSessions = sessionRepository.getAll();

        assertNotNull(allSessions, "getAll() should not return null");
        assertEquals(2, allSessions.size(), "Should return all created sessions");
        assertTrue(allSessions.contains(session1), "First session should be in the list");
        assertTrue(allSessions.contains(session2), "Second session should be in the list");
    }

    @Test
    void testMultipleOperations() {
        // Test a sequence of operations
        sessionRepository.create(session1);
        sessionRepository.create(session2);

        // Read
        Session readSession = sessionRepository.read(session1.getSessionID());
        assertNotNull(readSession, "Should be able to read created session");

        // Update
        Session updatedSession = new Session.Builder()
                .sessionID(session1.getSessionID())
                .bookingID(session1.getBookingID())
                .tutorID(session1.getTutorID())
                .student(session1.getStudent())
                .sessionStart(session1.getSessionStart())
                .sessionEnd(session1.getSessionEnd())
                .sessionStatus("Rescheduled")
                .location(session1.getLocation())
                .sessionSubject(session1.getSessionSubject())
                .build();
        Session resultSession = sessionRepository.update(updatedSession);
        assertEquals("Rescheduled", resultSession.getSessionStatus(), "Session should be updatable");

        // Delete
        boolean deleteResult = sessionRepository.delete(session2.getSessionID());
        assertTrue(deleteResult, "Should be able to delete a session");

        // Verify final state
        var remainingSessions = sessionRepository.getAll();
        assertEquals(1, remainingSessions.size(), "One session should remain after delete");
    }
}