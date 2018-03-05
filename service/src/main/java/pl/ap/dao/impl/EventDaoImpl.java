package pl.ap.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Repository;
import pl.ap.dao.IEventDao;
import pl.ap.domain.Event;

import java.util.List;

/**
 * Created by parado on 2015-05-11.
 */
@Repository(EventDaoImpl.BEAN_NAME)
public class EventDaoImpl extends IdentifiableDaoImpl<Event> implements IEventDao {
    public static final String BEAN_NAME = "eventDao";

    @Override
    public List<Event> findByDateRange(LocalDate start, LocalDate end) {
        Criteria criteria = createCriteria()
                .add(Restrictions.ge(Event.FIELD_DATE, start))
                .add(Restrictions.lt(Event.FIELD_DATE, end));
        return criteria.list();
    }
}
