package za.ac.cput.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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


    //Booking validation methods
    /*
     * Author: Henzley Dean Spogter
     */
    // Validate Booking ID (e.g., must start with 'B' and have 4 digits)
    public static boolean isValidBookingId(String bookingId) {
        if (bookingId == null) return false;
        return Pattern.matches("^B\\d{4}$", bookingId);
    }

    // Validate Date (ensure it's a valid future or current date)
    public static boolean isValidDate(String date) {
        if (date == null) return false;
        try {
            LocalDate bookingDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
            // Ensure date is not in the past
            return !bookingDate.isBefore(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // Validate Time
    // ensure it's a valid 24-hour time format
    public static boolean isValidTime(String time) {
        if (time == null) return false;
        try {
            LocalTime.parse(time);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // Validate Student Number
    // must start with 'ST' and have 6 digits
    public static boolean isValidStudentNumber(String studentNumber) {
        if (studentNumber == null) return false;
        return Pattern.matches("^ST\\d{6}$", studentNumber);
    }

    // Validate Booking Price
    // must be a positive number
    public static boolean isValidBookingPrice(String bookingPrice) {
        if (bookingPrice == null) return false;
        try {
            double price = Double.parseDouble(bookingPrice);
            return price >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Validate Booking Status
    // must be one of predefined statuses
    public static boolean isValidBookingStatus(String status) {
        if (status == null) return false;
        return status.equalsIgnoreCase("Confirmed") ||
                status.equalsIgnoreCase("Pending") ||
                status.equalsIgnoreCase("Cancelled");
    }
}






