package pl.ap.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.domain.common.IdentifiableEntity;

import java.util.List;

/**
 * Created by parado on 2014-10-15.
 */
public abstract class IdentifiableDaoImpl<T extends IdentifiableEntity> extends AbstractDaoImpl<T> implements IIdentifiableDao<T> {

    public T getBySid(String sid) {
        Criteria criteria = createCriteria()
                .add(Restrictions.eq(IdentifiableEntity.FIELD_SID, sid))
                .setMaxResults(1);
        return (T) criteria.uniqueResult();
    }

    @Override
    public List<T> findBySids(List<String> sids) {
        Criteria criteria = createCriteria()
                .add(Restrictions.in(IdentifiableEntity.FIELD_SID, sids));
        return criteria.list();
    }
}
