package reputable.users.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reputable.users.persistance.domain.Role;
import reputable.users.persistance.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByRoles(Role roles);
}
