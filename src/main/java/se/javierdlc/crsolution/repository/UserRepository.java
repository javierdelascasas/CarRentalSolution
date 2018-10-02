package se.javierdlc.crsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.javierdlc.crsolution.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
