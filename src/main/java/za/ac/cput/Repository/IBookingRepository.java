package za.ac.cput.repository;

import za.ac.cput.domain.Booking;

import java.util.List;

/*
 * BookingFactory.java
 * Repository Interface for Booking domain
 * Author: Henzley Spogter [230013309]
 * Date: 28 March 2025
 */

public interface IBookingRepository extends IRepository<Booking, String> {
    List<Booking> getAll();
}
