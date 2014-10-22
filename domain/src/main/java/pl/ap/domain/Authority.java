package pl.ap.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import pl.ap.domain.common.DataEntity;

import javax.persistence.*;

/**
 * Created by parado on 2014-10-15.
 */
@Entity
@Table(name = "authority")
public class Authority extends DataEntity {

    public static final String FIELD_KEY = "key";

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(name = "value", length = 128)
    @NotBlank
    @Length(max = 128)
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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