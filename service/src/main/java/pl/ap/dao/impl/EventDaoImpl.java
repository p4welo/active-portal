package pl.ap.dao.impl;

import org.springframework.stereotype.Repository;
import pl.ap.dao.IEventDao;
import pl.ap.domain.Event;

/**
 * Created by parado on 2015-05-11.
 */
@Repository(EventDaoImpl.BEAN_NAME)
public class EventDaoImpl extends IdentifiableDaoImpl<Event> implements IEventDao {
    public static final String BEAN_NAME = "eventDao";
}
