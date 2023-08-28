package reputable.users.communication.endpoint;

import org.springframework.web.bind.annotation.*;
import reputable.users.logic.EateryService;
import reputable.users.persistance.domain.Eatery;

import java.util.List;

@RestController
@RequestMapping("/eateries")
public class EateryEndpoint {
    private final EateryService eateryService;

    public EateryEndpoint(EateryService eateryService) {
        this.eateryService = eateryService;
    }

    @PostMapping
    Eatery addEatery(@RequestBody Eatery eatery) {
        return eateryService.addEatery(eatery);
    }
    @GetMapping
    List<Eatery> getEateries() {
        return eateryService.getEateries();
    }

    @PutMapping("/{eatery_id}")
    Eatery claimEatery(@PathVariable Long eatery_id, @RequestBody Long user_id) {
        return eateryService.claimEatery(eatery_id, user_id).orElse(null);
    }
}
