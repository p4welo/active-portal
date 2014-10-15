package pl.ap.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.domain.common.IdentifiableEntity;

/**
 * Created by parado on 2014-10-15.
 */
public abstract class IdentifiableDaoImpl<T extends IdentifiableEntity> extends AbstractDaoImpl<T> implements IIdentifiableDao<T> {

    public T getBySid(String sid) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq(IdentifiableEntity.FIELD_SID, sid));
        criteria.setMaxResults(1);
        return (T) criteria.uniqueResult();
    }
}
