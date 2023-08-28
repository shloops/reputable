package reputable.users.communication.endpoint;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import reputable.users.logic.UserService;
import reputable.users.persistance.domain.Eatery;
import reputable.users.persistance.domain.User;

import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserEndpoint {
    private final UserService userService;

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    Set<User> getUsers() {
        return userService.getAll();
    }

    @PostMapping("/sign-up")
    User signUp(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/here")
    @Secured("STANDARD")
    String access() {
        return "success";
    }

    @PutMapping("/{userId}/add/{eateryId}")
    Set<Eatery> addEateryToFavourites(@PathVariable Long userId, @PathVariable Long eateryId) {
        return userService.addEateryToFavourites(userId, eateryId);
    }
}
