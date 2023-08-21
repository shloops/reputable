package reputable.users.persistance.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    @Size(max = 20, message = "street number should not exceed 20 digits")
    private String streetNumber;
    @Size(max = 20, message = "door number should not exceed 20 digits")
    private String doorNumber;
    private String street;
    @Enumerated(EnumType.STRING)
    private City city;
    @Enumerated(EnumType.STRING)
    private Country country;
    @Size(max = 20, message = "post code should not exceed 20 digits")
    private String postcode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
