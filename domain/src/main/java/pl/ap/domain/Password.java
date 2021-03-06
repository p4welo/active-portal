package pl.ap.domain;

import org.hibernate.validator.constraints.NotBlank;
import pl.ap.domain.annotations.Unique;
import pl.ap.domain.common.DataEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by parado on 2014-09-30.
 */
@Entity
@Table(name = "password")
@Unique(fields = Password.FIELD_USER, message = Password.NON_UNIQUE_USER_MESSAGE, insensitive = false)
public class Password extends DataEntity {

    public static final String NON_UNIQUE_USER_MESSAGE = "user.not.unique";

    public static final String FIELD_USER = "user";

    public static final String FIELD_VALUE = "value";

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private User user;

    @Column
    @NotBlank
    private String value;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
