package pl.ap.domain.common;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: pawel
 * Date: 23.07.12
 * Time: 21:14
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public abstract class DataEntity implements Serializable {
    public static final String FIELD_ID = "id";

    public abstract Long getId();

    public abstract void setId(Long id);

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DataEntity) {
            return getId() == ((DataEntity) obj).getId();
        } else {
            return super.equals(obj);
        }
    }
}
