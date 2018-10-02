package se.javierdlc.crsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.javierdlc.crsolution.domain.CarCategory;

public interface CarCategoryRepository extends JpaRepository<CarCategory, Integer> {

    public CarCategory findByCarCategoryID(int id);
}
