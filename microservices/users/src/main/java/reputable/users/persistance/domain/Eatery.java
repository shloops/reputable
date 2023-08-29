package reputable.users.persistance.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Eatery {
    @Id
    @GeneratedValue
    private Long id;
    private String businessName;
    @ManyToOne
    private Address address;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "cuisine_id", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "cuisines")
    @Enumerated(EnumType.STRING)
    private Set<Cuisine> cuisines;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "keyword_id", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "keyword")
    @Enumerated(EnumType.STRING)
    private Set<Keyword> keywords;
    private String website;
    private String phoneNumber;
    //@JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    private User manager;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Cuisine> getCuisines() {
        return cuisines;
    }

    public void setCuisines(Set<Cuisine> cuisines) {
        this.cuisines = cuisines;
    }

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }
}
