package reputable.users.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reputable.users.persistance.domain.Eatery;

public interface EateryRepository extends JpaRepository<Eatery, Long> {
}
