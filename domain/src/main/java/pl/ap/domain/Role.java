package pl.ap.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import pl.ap.domain.common.DataEntity;

import javax.persistence.*;

/**
 * Created by parado on 2014-10-15.
 */
@Entity
@Table(name = "role")
public class Role extends DataEntity {

    public static final String FIELD_NAME = "name";

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(name = "name", length = 128)
    @NotBlank
    @Length(max = 128)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
