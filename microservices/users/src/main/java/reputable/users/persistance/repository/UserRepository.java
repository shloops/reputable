package reputable.users.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reputable.users.persistance.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
