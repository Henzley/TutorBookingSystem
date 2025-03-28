package za.ac.cput.factory;

import za.ac.cput.domain.Booking;
import za.ac.cput.util.Helper;

/*
 * BookingFactory.java
 * Factory class for Booking domain
 * Author: Henzley Spogter [230013309]
 * Date: 28 March 2025
 */
public class BookingFactory {

    // Method to create a Booking object with comprehensive validation
    public static Booking createBooking(String bookingId,
                                        String bookingDate,
                                        String bookingTime,
                                        String studentNumber,
                                        String bookingPrice,
                                        String bookingStatus) {
        // Validate booking ID
        if (!Helper.isValidBookingId(bookingId)) {
            throw new IllegalArgumentException("Invalid Booking ID");
        }

        // Validate booking date
        if (!Helper.isValidDate(bookingDate)) {
            throw new IllegalArgumentException("Invalid Booking Date");
        }

        // Validate booking time
        if (!Helper.isValidTime(bookingTime)) {
            throw new IllegalArgumentException("Invalid Booking Time");
        }

        // Validate student number
        if (!Helper.isValidStudentNumber(studentNumber)) {
            throw new IllegalArgumentException("Invalid Student Number");
        }

        // Validate booking price
        if (!Helper.isValidBookingPrice(bookingPrice)) {  // Changed from isValidPayment()
            throw new IllegalArgumentException("Invalid Booking Price");
        }

        // Validate booking status
        if (!Helper.isValidBookingStatus(bookingStatus)) {
            throw new IllegalArgumentException("Invalid Booking Status");
        }

        // If all validations pass, create and return the Booking object
        return new Booking.BookingBuilder()
                .setBookingId(bookingId)
                .setBookingDate(bookingDate)
                .setBookingTime(bookingTime)
                .setStudentNumber(studentNumber)
                .setBookingPrice(bookingPrice)
                .setBookingStatus(bookingStatus)
                .build();
    }
}