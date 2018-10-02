package se.javierdlc.crsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.javierdlc.crsolution.domain.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
