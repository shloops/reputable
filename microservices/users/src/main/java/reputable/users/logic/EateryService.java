package reputable.users.logic;

import org.springframework.stereotype.Service;
import reputable.users.persistance.domain.Eatery;
import reputable.users.persistance.repository.EateryRepository;
import reputable.users.persistance.repository.UserRepository;

import java.util.List;
import java.util.Optional;
@Service
public class EateryService {
    private final EateryRepository eateryRepository;
    private final UserRepository userRepository;

    public EateryService(EateryRepository eateryRepository, UserRepository userRepository) {
        this.eateryRepository = eateryRepository;
        this.userRepository = userRepository;
    }

    public Eatery addEatery(Eatery eatery) {
        return eateryRepository.save(eatery);
    }

    public List<Eatery> getEateries() {
        return eateryRepository.findAll();
    }

    public Optional<Eatery> claimEatery(Long eatery_id, Long user_id) {
        //TODO add auth that is manager and not other users
        // tidy up exceptions
        var oEatery = eateryRepository.findById(eatery_id);
        if (oEatery.isPresent()) {
            var oUser = userRepository.findById(user_id);
            if (oUser.isPresent()) {
                var eatery = oEatery.get();
                eatery.setManager(oUser.get());
                return Optional.of(eateryRepository.save(eatery));
            } else {
                throw new RuntimeException("no such user found, check id");
            }
        } else {
            return Optional.empty();
        }
    }

}
