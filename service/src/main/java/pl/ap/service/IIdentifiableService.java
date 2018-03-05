package pl.ap.service;

import org.springframework.transaction.annotation.Transactional;
import pl.ap.domain.Instructor;
import pl.ap.domain.common.IdentifiableEntity;

import java.util.List;

/**
 * Created by parado on 2014-10-15.
 */
public interface IIdentifiableService<T extends IdentifiableEntity> extends IAbstractService<T> {

    T getBySid(String sid);

    T activate(T obj);

    T deactivate(T obj);

    List<T> findBySids(List<String> sids);

    T merge(T entity);
}
