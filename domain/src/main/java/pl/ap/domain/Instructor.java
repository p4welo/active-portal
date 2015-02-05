package pl.ap.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import pl.ap.domain.annotations.Unique;
import pl.ap.domain.common.IdentifiableEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by parado on 18.03.14.
 */
@Entity
@Table(name = "instructor")
@Unique(fields = Instructor.FIELD_SID, message = Instructor.NON_UNIQUE_SID_MESSAGE, insensitive = false)
public class Instructor extends IdentifiableEntity {
    public static final String FIELD_FIRST_NAME = "firstName";

    public static final String FIELD_LAST_NAME = "lastName";

    public static final String FIELD_NICK = "nick";

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(name = "first_name", nullable = false, length = 64)
    @Length(max = 64)
    @NotBlank
    private String firstName;

    @Column(name = "last_name", length = 64, nullable = true)
    @Length(max = 64)
    private String lastName;

    @Column(length = 64, nullable = true)
    @Length(max = 64)
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
