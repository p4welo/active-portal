package pl.ap.service.impl;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.dao.IEventDao;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.domain.Event;
import pl.ap.service.IEventService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2015-05-11.
 */
@Service(EventServiceImpl.BEAN_NAME)
public class EventServiceImpl extends IdentifiableServiceImpl<Event> implements IEventService {

    public static final String BEAN_NAME = "eventService";

    @Resource
    private IEventDao eventDao;

    @Override
    protected IIdentifiableDao<Event> getDao() {
        return eventDao;
    }

    @Override
    @Transactional(readOnly = false)
    public Event save(Event obj) {
        obj.setCreatedAt(new DateTime());
        obj.setCreatedBy("parado");
        return super.save(obj);
    }

    @Override
    protected String[] getUpdateFields() {
        return new String[]{
                Event.FIELD_DATE,
                Event.FIELD_START_TIME,
                Event.FIELD_END_TIME,
                Event.FIELD_PERSON,
                Event.FIELD_DESCRIPTION,
                Event.FIELD_ROOM,
                Event.FIELD_TYPE
        };
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> findByDateRange(LocalDate start, LocalDate end) {
//        LocalDate startDate = new LocalDate(start.getYear(), start.getMonthOfYear(), start.getDayOfMonth());
//        LocalDate endDate = new LocalDate(end.getYear(), end.getMonthOfYear(), end.getDayOfMonth());
        return eventDao.findByDateRange(start, end);
    }
}
