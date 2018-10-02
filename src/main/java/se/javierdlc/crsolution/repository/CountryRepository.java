package se.javierdlc.crsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.javierdlc.crsolution.domain.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
