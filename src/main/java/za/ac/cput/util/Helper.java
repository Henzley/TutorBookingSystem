package za.ac.cput.util;

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
//helper methods to check for nulls and proper inputs
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
//ID is generated for account
    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}