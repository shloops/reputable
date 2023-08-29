package reputable.users.security;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import reputable.users.persistance.domain.Role;
import reputable.users.persistance.domain.User;
import reputable.users.persistance.repository.UserRepository;

import java.util.Set;

@Configuration
public class SuperAdminRunner {
    @Bean
    ApplicationRunner prepareUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (!userRepository.existsByRoles(Role.SUPER_ADMIN)) {
                userRepository.save(new User("super-admin@reputable.com", "Super!Admin1", Set.of(Role.SUPER_ADMIN)));
                //TODO - encodes password
            }
        };
    }
}
