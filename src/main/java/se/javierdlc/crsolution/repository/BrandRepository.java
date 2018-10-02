package se.javierdlc.crsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.javierdlc.crsolution.domain.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
