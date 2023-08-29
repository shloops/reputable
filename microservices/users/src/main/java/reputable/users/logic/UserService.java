package reputable.users.logic;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reputable.users.persistance.domain.Eatery;
import reputable.users.persistance.domain.Role;
import reputable.users.persistance.domain.User;
import reputable.users.persistance.repository.EateryRepository;
import reputable.users.persistance.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EateryRepository eateryRepository;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       EateryRepository eateryRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.eateryRepository = eateryRepository;
    }
    public Set<User> getAll() {
        return new HashSet<>(userRepository.findAll());
    }

    public User addUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("email in use");
            //TODO - tidy up errors
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(Role.STANDARD));
        return userRepository.save(user);
    }
    public User grantManagerOrStaffAuthority(Role role, Long userId) {
        var oUser = userRepository.findById(userId);
        if (oUser.isPresent()) {
            var user = oUser.get();
            user.getRoles().add(role);
            return userRepository.save(user);
        } else {
            throw new RuntimeException("user not found");
        }
    }
    public Set<Eatery> addEateryToFavourites(Long userId, Long eateryId) {
        if (eateryRepository.existsById(eateryId)) {
            Eatery eatery = eateryRepository.findById(eateryId).get();
            if (userRepository.existsById(userId)) {
                var user = userRepository.findById(userId).get();
                user.getFavouriteEateries().add(eatery);
                userRepository.save(user);
                return user.getFavouriteEateries();
            }
            throw new RuntimeException("user not found");
        }
        throw new RuntimeException("eatery not found");
    }
}
