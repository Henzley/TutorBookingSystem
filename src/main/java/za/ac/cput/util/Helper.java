package za.ac.cput.util;

import za.ac.cput.domain.Student;
import za.ac.cput.domain.Subject;

import java.util.UUID;
import java.util.regex.Pattern;

/**
 * Helper.java
 * Utility class for common functions
 * Author: [Cameron Savage] ([230582567])
 * Date: [26/03/2025]
 */
public class Helper {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }


    public static boolean isValidSessionData(String sessionID, String bookingID, String tutorID,
                                             Student student, String sessionStart, String sessionEnd,
                                             String sessionStatus, String location, Subject sessionSubject) {
        return isValidString(sessionID) &&
                isValidString(bookingID) &&
                isValidString(tutorID) &&
                isValidStudent(student) &&
                isValidTime(sessionStart) &&
                isValidTime(sessionEnd) &&
                isValidString(sessionStatus) &&
                isValidString(location) &&
                isValidSubject(sessionSubject);
    }

    private static boolean isValidString(String value) {
        return value != null && !value.trim().isEmpty();
    }

    private static boolean isValidStudent(Student student) {
        return student != null;
    }

    private static boolean isValidTime(String time) {
        return time != null && !time.trim().isEmpty(); // Ensure a valid non-empty time string
    }

    private static boolean isValidSubject(Subject subject) {
        return subject != null;
    }


}