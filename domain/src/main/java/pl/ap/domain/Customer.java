package pl.ap.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import pl.ap.domain.annotations.Unique;
import pl.ap.domain.common.IdentifiableEntity;
import pl.ap.domain.enums.GenderEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by parado on 2014-09-24.
 */
@Entity
@Table(name = "customer")
@Unique(fields = Customer.FIELD_SID, message = Customer.NON_UNIQUE_SID_MESSAGE, insensitive = false)
public class Customer extends IdentifiableEntity {

    public static final String FIELD_FIRST_NAME = "firstName";

    public static final String FIELD_LAST_NAME = "lastName";

    public static final String FIELD_MOBILE = "mobile";

    public static final String FIELD_MOBILE2 = "mobile2";

    public static final String FIELD_EMAIL = "email";

    public static final String FIELD_GENDER = "gender";

    public static final String FIELD_CONTACT_DATA_LIST = "contactDataList";

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(name = "first_name", length = 25, nullable = false)
    @NotBlank
    @Length(max = 25)
    private String firstName;

    @Column(name = "last_name", length = 35)
    @Length(max = 35)
    private String lastName;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private GenderEnum gender;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "customer_id", nullable = false)
    private List<CustomerContactData> contactDataList;

    public List<CustomerContactData> getContactDataList() {
        return contactDataList;
    }

    public void setContactDataList(List<CustomerContactData> contactDataList) {
        this.contactDataList = contactDataList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getFirstName() + "/" + getLastName() + "/" + getGender();
    }
}
