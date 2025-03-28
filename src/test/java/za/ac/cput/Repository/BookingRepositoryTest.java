package za.ac.cput.repository;

import za.ac.cput.domain.Booking;
import za.ac.cput.factory.BookingFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
/*
 * BookingRepositoryTest.java
 * Test for 'BookingRepositoryTest'
 * Author: Henzley Spogter [230013309]
 * Date: 28 March 2025
 */

public class BookingRepositoryTest {
    private BookingRepository bookingRepository;
    private Booking booking1, booking2;

    @BeforeEach
    public void setUp() {
        // Reset singleton instance before each test
        bookingRepository = BookingRepository.getInstance();

        // test bookings
        booking1 = BookingFactory.createBooking(
                "B8493",
                "2025-04-15",
                "14:30",
                "ST894035",
                "50.00",
                "Confirmed"
        );

        booking2 = BookingFactory.createBooking(
                "B1234",
                "2025-05-20",
                "15:45",
                "ST654321",
                "75.50",
                "Pending"
        );
    }

    @Test
    public void testCreate() {
        Booking createdBooking = bookingRepository.create(booking1);
        assertNotNull(createdBooking);
        assertEquals(booking1, createdBooking);
    }

    @Test
    public void testRead() {
        bookingRepository.create(booking1);
        Booking retrievedBooking = bookingRepository.read("B0001");
        assertNotNull(retrievedBooking);
        assertEquals(booking1, retrievedBooking);
    }

    @Test
    public void testReadNonExistentBooking() {
        Booking retrievedBooking = bookingRepository.read("B9999");
        assertNull(retrievedBooking);
    }

    @Test
    public void testUpdate() {
        bookingRepository.create(booking1);

        Booking updatedBooking = BookingFactory.createBooking(
                "B0001",
                "2025-04-16",
                "16:00",
                "ST123456",
                "60.00",
                "Cancelled"
        );

        Booking result = bookingRepository.update(updatedBooking);
        assertNotNull(result);
        assertEquals(updatedBooking, result);
    }

    @Test
    public void testUpdateNonExistentBooking() {
        Booking nonExistentBooking = BookingFactory.createBooking(
                "B9999",
                "2025-04-16",
                "16:00",
                "ST123456",
                "60.00",
                "Cancelled"
        );

        Booking result = bookingRepository.update(nonExistentBooking);
        assertNull(result);
    }

    @Test
    public void testDelete() {
        bookingRepository.create(booking1);
        boolean deleted = bookingRepository.delete("B0001");
        assertTrue(deleted);
    }

    @Test
    public void testDeleteNonExistentBooking() {
        boolean deleted = bookingRepository.delete("B9999");
        assertFalse(deleted);
    }

    @Test
    public void testGetAll() {
        bookingRepository.create(booking1);
        bookingRepository.create(booking2);

        List<Booking> bookings = bookingRepository.getAll();
        assertNotNull(bookings);
        assertEquals(2, bookings.size());
    }

    @Test
    public void testSingleton() {
        BookingRepository instance1 = BookingRepository.getInstance();
        BookingRepository instance2 = BookingRepository.getInstance();

        assertSame(instance1, instance2);
    }
}
