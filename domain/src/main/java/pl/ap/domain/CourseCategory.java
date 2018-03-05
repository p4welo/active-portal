package pl.ap.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import pl.ap.domain.annotations.Unique;
import pl.ap.domain.common.IdentifiableEntity;

import javax.persistence.*;

/**
 * Created by parado on 18.03.14.
 */
@Entity
@Table(name = "category")
@Unique(fields = CourseCategory.FIELD_SID, message = CourseCategory.NON_UNIQUE_SID_MESSAGE, insensitive = false)
public class CourseCategory extends IdentifiableEntity {
    public static final String FIELD_NAME = "name";

    public static final String FIELD_CODE = "code";

    public static final int MAX_LENGTH_NAME = 128;

    public static final int MAX_LENGTH_CODE = 32;

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @NotBlank
    @Column(length = MAX_LENGTH_NAME)
    @Length(max = MAX_LENGTH_NAME)
    private String name;

    @NotBlank
    @Column(length = MAX_LENGTH_CODE)
    @Length(max = MAX_LENGTH_CODE)
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getCode() + "/" + getName();
    }
}
