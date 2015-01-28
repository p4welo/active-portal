package pl.ap.domain;

import pl.ap.domain.common.DataEntity;
import pl.ap.domain.enums.ContactDataTypeEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by parado on 2015-01-28.
 */
@Entity
@Table(name = "customer_contact_data")
public class CustomerContactData extends DataEntity {

    public static final String FIELD_TYPE = "type";

    public static final String FIELD_VALUE = "value";

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.ORDINAL)
    @NotNull
    private ContactDataTypeEnum type;

    @Column
    private String value;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public ContactDataTypeEnum getType() {
        return type;
    }

    public void setType(ContactDataTypeEnum type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
