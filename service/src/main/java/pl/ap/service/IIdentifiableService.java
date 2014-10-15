package pl.ap.service;

import pl.ap.domain.common.IdentifiableEntity;

/**
 * Created by parado on 2014-10-15.
 */
public interface IIdentifiableService<T extends IdentifiableEntity> extends IAbstractService<T> {

    T getBySid(String sid);
}
