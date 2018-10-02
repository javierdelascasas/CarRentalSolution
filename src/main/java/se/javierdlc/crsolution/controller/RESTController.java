package se.javierdlc.crsolution.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.javierdlc.crsolution.domain.Booking;
import se.javierdlc.crsolution.domain.Car;
import se.javierdlc.crsolution.domain.CarCategory;
import se.javierdlc.crsolution.io.SearchCarForm;
import se.javierdlc.crsolution.repository.BookingRepository;
import se.javierdlc.crsolution.repository.CRSRepository;
import se.javierdlc.crsolution.repository.CarCategoryRepository;
import se.javierdlc.crsolution.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RESTController {

    @Autowired
    CRSRepository crsRepository;

    @Autowired
    CarCategoryRepository carCategoryRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    BookingRepository bookingRepository;

    @PostMapping("/searchAvailableCars")
    public String searchAvailableCars(@RequestBody SearchCarForm form) {
        List<Car> cars = crsRepository.getAvailableCars(form);
        Gson gson = new Gson();
        return gson.toJson(cars);
    }
}
