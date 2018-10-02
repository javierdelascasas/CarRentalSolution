package se.javierdlc.crsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.javierdlc.crsolution.domain.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}

