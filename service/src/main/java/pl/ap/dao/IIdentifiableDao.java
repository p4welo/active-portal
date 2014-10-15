package pl.ap.dao;

import pl.ap.domain.common.IdentifiableEntity;

/**
 * Created by parado on 2014-10-15.
 */
public interface IIdentifiableDao<T extends IdentifiableEntity> extends IAbstractDao<T> {

    T getBySid(String sid);
}
