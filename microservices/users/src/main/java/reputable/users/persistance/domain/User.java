package reputable.users.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Email
    private String email;
    private String firstName;
    private String lastName;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{9,21}$", message = "Password must be between 9-20 characters and contain at least one UPPER, one lower, one number (0-9), and one special character (!@#$%^&*)")
    private String password;
    private String userName;
    private Set<Role> roles;

    
    //phoneNumber?
    //area code → enum [“+33”]
    //string → only accepts numbers (max length 20)
    //address
    //number
    //street
    //city
    //country
    //postcode
    //dob → Date
}
