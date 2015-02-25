package pl.ap.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import pl.ap.domain.annotations.Unique;
import pl.ap.domain.common.IdentifiableEntity;

import javax.persistence.*;

/**
 * Created by parado on 2015-02-25.
 */
@Entity
@Table(name = "ticket_type_group")
@Unique(fields = TicketTypeGroup.FIELD_SID, message = TicketTypeGroup.NON_UNIQUE_SID_MESSAGE, insensitive = false)
public class TicketTypeGroup extends IdentifiableEntity {

    public static final String FIELD_NAME = "name";

    public static final int MAX_LENGTH_NAME = 128;

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @NotBlank
    @Column(length = MAX_LENGTH_NAME)
    @Length(max = MAX_LENGTH_NAME)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
