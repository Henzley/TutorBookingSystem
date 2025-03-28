package za.ac.cput.Factory;
/*Session.java
Session Factory class
Author: Hope Ringane(221174109)
Date 28 March 2.25
 */
import za.ac.cput.domain.Session;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Subject;
import za.ac.cput.util.Helper;

public class SessionFactory {

    public static Session createSession(String sessionID, String bookingID, String tutorID,
                                        Student student, String sessionStart, String sessionEnd,
                                        String sessionStatus, String location, Subject sessionSubject) {

        if (!Helper.isValidSessionData(sessionID, bookingID, tutorID, student, sessionStart, sessionEnd, sessionStatus, location, sessionSubject)) {
            throw new IllegalArgumentException("Invalid session data");
        }

        return new Session.Builder()
                .sessionID(sessionID)
                .bookingID(bookingID)
                .tutorID(tutorID)
                .student(student)
                .sessionStart(sessionStart)
                .sessionEnd(sessionEnd)
                .sessionStatus(sessionStatus)
                .location(location)
                .sessionSubject(sessionSubject)
                .build();
    }
}
