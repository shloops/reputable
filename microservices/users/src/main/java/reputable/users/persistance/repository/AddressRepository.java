package reputable.users.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reputable.users.persistance.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
