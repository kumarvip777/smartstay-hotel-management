package org.kumar.hotel.repository;

import org.kumar.hotel.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository
        extends JpaRepository<Booking, Long> {
}
