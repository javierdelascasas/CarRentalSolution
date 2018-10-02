package se.javierdlc.crsolution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import se.javierdlc.crsolution.domain.CarCategory;
import se.javierdlc.crsolution.domain.Location;
import se.javierdlc.crsolution.repository.CarCategoryRepository;
import se.javierdlc.crsolution.repository.LocationRepository;

import java.util.List;

@Controller
public class CRSController {

    @Autowired
    CarCategoryRepository carCategoryRepository;

    @Autowired
    LocationRepository locationRepository;

    @GetMapping("/")
    public ModelAndView getHomePage() {
        List<CarCategory> carTypes = carCategoryRepository.findAll();
        List<Location> locations = locationRepository.findAll();
        return new ModelAndView("index")
                .addObject("carTypes", carTypes)
                .addObject("locations", locations);
    }

}