package se.javierdlc.crsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.javierdlc.crsolution.domain.Booking;
import se.javierdlc.crsolution.domain.Car;
import se.javierdlc.crsolution.domain.CarCategory;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByCarCategory(CarCategory carCategory);

    List<Car> findByCarIDNotInAndCarCategory(List<Integer> bookings, CarCategory carCategory);

    List<Car> findCarsByCarIDIsNotInAndCarCategory(List<Integer> bookings, CarCategory carCategory);

}
