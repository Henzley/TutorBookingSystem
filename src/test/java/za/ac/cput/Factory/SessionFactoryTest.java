package za.ac.cput.factory;

import za.ac.cput.domain.Session;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Subject;
import za.ac.cput.util.Helper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SessionFactoryTest {
    private Student testStudent;
    private Subject testSubject;

    @BeforeEach
    void setUp() {
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
    }

    @Test
    void testCreateSession_ValidData() {
        // Arrange
        String sessionID = "SES001";
        String bookingID = "BOOK001";
        String tutorID = "TUT001";
        String sessionStart = "2024-03-28 10:00";
        String sessionEnd = "2024-03-28 11:00";
        String sessionStatus = "Scheduled";
        String location = "Study Room A";

        // Act
        Session session = SessionFactory.createSession(
                sessionID, bookingID, tutorID,
                testStudent, sessionStart, sessionEnd,
                sessionStatus, location, testSubject
        );

        // Assert
        assertNotNull(session, "Session should not be null");
        assertEquals(sessionID, session.getSessionID(), "Session ID should match");
        assertEquals(bookingID, session.getBookingID(), "Booking ID should match");
        assertEquals(tutorID, session.getTutorID(), "Tutor ID should match");
        assertEquals(testStudent, session.getStudent(), "Student should match");
        assertEquals(sessionStart, session.getSessionStart(), "Session start time should match");
        assertEquals(sessionEnd, session.getSessionEnd(), "Session end time should match");
        assertEquals(sessionStatus, session.getSessionStatus(), "Session status should match");
        assertEquals(location, session.getLocation(), "Location should match");
        assertEquals(testSubject, session.getSessionSubject(), "Subject should match");
    }

    @Test
    void testCreateSession_InvalidData() {
        // Test with null or empty values
        assertThrows(IllegalArgumentException.class, () ->
                SessionFactory.createSession(
                        null, "BOOK001", "TUT001",
                        testStudent, "2024-03-28 10:00", "2024-03-28 11:00",
                        "Scheduled", "Study Room A", testSubject
                ), "Null sessionID should throw IllegalArgumentException"
        );

        assertThrows(IllegalArgumentException.class, () ->
                SessionFactory.createSession(
                        "SES001", null, "TUT001",
                        testStudent, "2024-03-28 10:00", "2024-03-28 11:00",
                        "Scheduled", "Study Room A", testSubject
                ), "Null bookingID should throw IllegalArgumentException"
        );

        assertThrows(IllegalArgumentException.class, () ->
                SessionFactory.createSession(
                        "SES001", "BOOK001", null,
                        testStudent, "2024-03-28 10:00", "2024-03-28 11:00",
                        "Scheduled", "Study Room A", testSubject
                ), "Null tutorID should throw IllegalArgumentException"
        );

        assertThrows(IllegalArgumentException.class, () ->
                SessionFactory.createSession(
                        "SES001", "BOOK001", "TUT001",
                        null, "2024-03-28 10:00", "2024-03-28 11:00",
                        "Scheduled", "Study Room A", testSubject
                ), "Null student should throw IllegalArgumentException"
        );

        assertThrows(IllegalArgumentException.class, () ->
                SessionFactory.createSession(
                        "SES001", "BOOK001", "TUT001",
                        testStudent, null, "2024-03-28 11:00",
                        "Scheduled", "Study Room A", testSubject
                ), "Null session start should throw IllegalArgumentException"
        );

        assertThrows(IllegalArgumentException.class, () ->
                SessionFactory.createSession(
                        "SES001", "BOOK001", "TUT001",
                        testStudent, "2024-03-28 10:00", null,
                        "Scheduled", "Study Room A", testSubject
                ), "Null session end should throw IllegalArgumentException"
        );

        assertThrows(IllegalArgumentException.class, () ->
                SessionFactory.createSession(
                        "SES001", "BOOK001", "TUT001",
                        testStudent, "2024-03-28 10:00", "2024-03-28 11:00",
                        null, "Study Room A", testSubject
                ), "Null session status should throw IllegalArgumentException"
        );

        assertThrows(IllegalArgumentException.class, () ->
                SessionFactory.createSession(
                        "SES001", "BOOK001", "TUT001",
                        testStudent, "2024-03-28 10:00", "2024-03-28 11:00",
                        "Scheduled", null, testSubject
                ), "Null location should throw IllegalArgumentException"
        );

        assertThrows(IllegalArgumentException.class, () ->
                SessionFactory.createSession(
                        "SES001", "BOOK001", "TUT001",
                        testStudent, "2024-03-28 10:00", "2024-03-28 11:00",
                        "Scheduled", "Study Room A", null
                ), "Null subject should throw IllegalArgumentException"
        );
    }

    @Test
    void testCreateSession_InvalidFormat() {
        // Assuming Helper.isValidSessionData() checks for additional format constraints
        // This test depends on the specific validation in the Helper class
        // You might want to add more specific tests based on your Helper.isValidSessionData() implementation
        assertThrows(IllegalArgumentException.class, () ->
                SessionFactory.createSession(
                        "", "BOOK001", "TUT001",
                        testStudent, "2024-03-28 10:00", "2024-03-28 11:00",
                        "Scheduled", "Study Room A", testSubject
                ), "Empty sessionID should throw IllegalArgumentException"
        );
    }
}