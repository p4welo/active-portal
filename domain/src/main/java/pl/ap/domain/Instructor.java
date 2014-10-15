package pl.ap.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import pl.ap.domain.common.IdentifiableEntity;

import javax.persistence.*;

/**
 * Created by parado on 18.03.14.
 */
@Entity
@Table(name = "instructor")
public class Instructor extends IdentifiableEntity {
    public static final String FIELD_FIRST_NAME = "firstName";

    public static final String FIELD_LAST_NAME = "lastName";

    public static final String FIELD_NICK = "nick";

    public static final int MAX_LENGTH_FIRST_NAME = 64;

    public static final int MAX_LENGTH_LAST_NAME = 64;

    public static final int MAX_LENGTH_NICK = 64;

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(name = "first_name", nullable = false, length = MAX_LENGTH_FIRST_NAME)
    @Length(max = MAX_LENGTH_FIRST_NAME)
    @NotBlank
    private String firstName;

    @Column(name = "last_name", length = MAX_LENGTH_LAST_NAME, nullable = true)
    @Length(max = MAX_LENGTH_LAST_NAME)
    private String lastName;

    @Column(length = MAX_LENGTH_NICK, nullable = true)
    @Length(max = MAX_LENGTH_NICK)
    private String nick;

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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
