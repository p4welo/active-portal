package pl.ap.domain;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import pl.ap.domain.annotations.Unique;
import pl.ap.domain.common.IdentifiableEntity;
import pl.ap.domain.enums.UserTypeEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * User: pawel
 * Date: 17.12.12
 * Time: 19:16
 */
@Entity
@Table(name = "user")
@Unique(fields = User.FIELD_SID, message = User.NON_UNIQUE_SID_MESSAGE, insensitive = false)
public class User extends IdentifiableEntity {
    public static final String FIELD_FIRST_NAME = "firstName";

    public static final String FIELD_LAST_NAME = "lastName";

    public static final String FIELD_LOGIN = "login";

    public static final String FIELD_PASSWORD = "password";

    public static final String FIELD_EMAIL = "email";

    public static final String FIELD_ROLE = "role";

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(name = "first_name", nullable = false, length = 25)
    @Length(max = 25)
    @NotBlank
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 35)
    @Length(max = 35)
    @NotBlank
    private String lastName;

    @Column(nullable = false, length = 15)
    @Length(max = 15)
    @NotBlank
    private String login;

    @Column(nullable = false)
    @NotBlank
    private String password;

    @Column(nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    @ForeignKey(name = "role_fk")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @NotNull
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
