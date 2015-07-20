package pl.ap.domain;

import org.hibernate.validator.constraints.NotBlank;
import pl.ap.domain.annotations.Unique;
import pl.ap.domain.common.IdentifiableEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by parado on 18.03.14.
 */
@Deprecated
@Entity
@Table(name = "instructor_description")
@Unique(fields = InstructorDescription.FIELD_SID, message = InstructorDescription.NON_UNIQUE_SID_MESSAGE, insensitive = false)
public class InstructorDescription extends IdentifiableEntity {
    public static final String FIELD_INSTRUCTOR = "instructor";

    public static final String FIELD_DESCRIPTION = "description";

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id", nullable = false)
    @NotNull
    private Instructor instructor;

    @Column
    @NotBlank
    private String description;

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
