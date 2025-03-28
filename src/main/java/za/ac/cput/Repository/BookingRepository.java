package za.ac.cput.repository;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Subject;

import java.util.ArrayList;
import java.util.List;

/*
 * BookingRepository.java
 * Repository implementation for 'Booking'
 * Author: [Your Name]
 * Date: 28 March 2025
 */
public class BookingRepository implements IBookingRepository {

    //ArrayList to store bookings
    private static BookingRepository repository = null;
    private List<Booking> bookingList;

    // Private constructor that implements Singleton pattern
    private BookingRepository() {
        bookingList = new ArrayList<>();
    }

    // Singleton getInstance method
    public static BookingRepository getInstance() {
        if (repository == null) {
            repository = new BookingRepository();
        }
        return repository;
    }

    @Override
    public Booking create(Booking booking) {
        // Check if booking is null or has no ID
        if (booking == null || booking.getBookingId() == null) {
            return null;
        }

        // Prevent duplicate entries
        if (exists(booking.getBookingId())) {
            return null;
        }

        // Add booking to the list
        bookingList.add(booking);
        return booking;
    }

    @Override
    public Booking read(String bookingId) {
        // Find and return booking by its ID
        for (Booking booking : bookingList) {
            if (booking.getBookingId().equals(bookingId)) {
                return booking;
            }
        }
        return null;
    }

    @Override
    public Booking update(Booking booking) {
        // Check if booking exists before updating
        if (booking == null) {
            return null;
        }

        // Find the index of existing booking
        int index = findIndexByBookingId(booking.getBookingId());

        // If booking not found, return null
        if (index == -1) {
            return null;
        }

        // Replace existing booking
        bookingList.set(index, booking);
        return booking;
    }

    @Override
    public boolean delete(String bookingId) {
        // Find the index of booking to delete
        int index = findIndexByBookingId(bookingId);

        // If booking not found, return false
        if (index == -1) {
            return false;
        }

        // Remove booking from list
        bookingList.remove(index);
        return true;
    }

    @Override
    public List<Booking> getAll() {
        // Return a new ArrayList to prevent direct modification
        return new ArrayList<>(bookingList);
    }

    // Helper method to find booking index by ID
    private int findIndexByBookingId(String bookingId) {
        for (int i = 0; i < bookingList.size(); i++) {
            if (bookingList.get(i).getBookingId().equals(bookingId)) {
                return i;
            }
        }
        return -1;
    }

    // Helper method to check if booking exists
    private boolean exists(String bookingId) {
        return findIndexByBookingId(bookingId) != -1;
    }

    // Optional: Method to get the total number of bookings
    public int getBookingCount() {
        return bookingList.size();
    }
}