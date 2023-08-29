package reputable.users.persistance.domain.manager;

public class EateryDTO {
    private Long id;
    private Long businessName;

    public EateryDTO(Long id, Long businessName) {
        this.id = id;
        this.businessName = businessName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusinessName() {
        return businessName;
    }

    public void setBusinessName(Long businessName) {
        this.businessName = businessName;
    }
}
