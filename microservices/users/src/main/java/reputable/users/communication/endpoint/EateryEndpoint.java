package reputable.users.communication.endpoint;

import org.springframework.web.bind.annotation.*;
import reputable.users.persistance.domain.Eatery;
import reputable.users.persistance.repository.EateryRepository;
import reputable.users.persistance.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/eateries")
public class EateryEndpoint {
    private final EateryRepository eateryRepository;
    private final UserRepository userRepository;

    public EateryEndpoint(EateryRepository eateryRepository, UserRepository userRepository) {
        this.eateryRepository = eateryRepository;
        this.userRepository = userRepository;
    }

    //TODO - move to logic layer

    @PostMapping
    Eatery addEatery(@RequestBody Eatery eatery) {
        return eateryRepository.save(eatery);
    }
    @GetMapping
    List<Eatery> getEateries() {
        return eateryRepository.findAll();
    }

    @PutMapping("/{eatery_id}")
    Eatery claimEatery(@PathVariable Long eatery_id, @RequestBody Long user_id) {
    //TODO add auth that is manager and not other users
        var oEatery = eateryRepository.findById(eatery_id);
        if (oEatery.isPresent()) {
            var oUser = userRepository.findById(user_id);
            if (oUser.isPresent()) {
                var e = oEatery.get();
                e.setManager(oUser.get());
                return eateryRepository.save(e);
            } else {
                throw new RuntimeException("no such user found, check id");
            }
        } else {
            throw new RuntimeException("no such eatery found, check id");
        }
    }
}
