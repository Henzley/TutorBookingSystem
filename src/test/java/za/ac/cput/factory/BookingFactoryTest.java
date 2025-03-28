package za.ac.cput.factory;


import za.ac.cput.domain.Booking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * BookingFactoryTest.java
 * Test for 'BookingFactoryTest
 * Author: Henzley Spogter [230013309]
 * Date: 28 March 2025
 */

public class BookingFactoryTest {
    @Test
    public void testCreateBookingWithValidData() {
        Booking booking = BookingFactory.createBooking(
                "B0001",
                "2025-04-15",
                "14:30",
                "ST123456",
                "50.00",
                "Confirmed"
        );

        assertNotNull(booking);
        assertEquals("B0001", booking.getBookingId());
        assertEquals("2025-04-15", booking.getBookingDate());
        assertEquals("14:30", booking.getBookingTime());
        assertEquals("ST123456", booking.getStudentNumber());
        assertEquals("50.00", booking.getBookingPrice());
        assertEquals("Confirmed", booking.getBookingStatus());
    }

    @Test
    public void testCreateBookingWithInvalidBookingId() {
        assertThrows(IllegalArgumentException.class, () ->
                BookingFactory.createBooking(
                        "INVALID",
                        "2025-04-15",
                        "14:30",
                        "ST123456",
                        "50.00",
                        "Confirmed"
                )
        );
    }

    @Test
    public void testCreateBookingWithPastDate() {
        assertThrows(IllegalArgumentException.class, () ->
                BookingFactory.createBooking(
                        "B0001",
                        "2023-01-01",
                        "14:30",
                        "ST123456",
                        "50.00",
                        "Confirmed"
                )
        );
    }

    @Test
    public void testCreateBookingWithInvalidTime() {
        assertThrows(IllegalArgumentException.class, () ->
                BookingFactory.createBooking(
                        "B0001",
                        "2025-04-15",
                        "25:00",
                        "ST123456",
                        "50.00",
                        "Confirmed"
                )
        );
    }

    @Test
    public void testCreateBookingWithInvalidStudentNumber() {
        assertThrows(IllegalArgumentException.class, () ->
                BookingFactory.createBooking(
                        "B0001",
                        "2025-04-15",
                        "14:30",
                        "INVALID",
                        "50.00",
                        "Confirmed"
                )
        );
    }

    @Test
    public void testCreateBookingWithInvalidBookingPrice() {
        assertThrows(IllegalArgumentException.class, () ->
                BookingFactory.createBooking(
                        "B0001",
                        "2025-04-15",
                        "14:30",
                        "ST123456",
                        "-50.00",
                        "Confirmed"
                )
        );
    }

    @Test
    public void testCreateBookingWithInvalidBookingStatus() {
        assertThrows(IllegalArgumentException.class, () ->
                BookingFactory.createBooking(
                        "B0001",
                        "2025-04-15",
                        "14:30",
                        "ST123456",
                        "50.00",
                        "INVALID"
                )
        );
    }
}
