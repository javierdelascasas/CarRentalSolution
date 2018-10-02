package se.javierdlc.crsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.javierdlc.crsolution.domain.Booking;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findByBookingReturntimeIsNullOrBookingReturntimeIsGreaterThan(LocalDateTime dateTime);
}
