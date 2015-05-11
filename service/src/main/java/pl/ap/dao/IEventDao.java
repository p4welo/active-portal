package pl.ap.dao;

import org.joda.time.LocalDate;
import pl.ap.domain.Event;

import java.util.List;

/**
 * Created by parado on 2015-05-11.
 */
public interface IEventDao extends IIdentifiableDao<Event> {
    List<Event> findByDateRange(LocalDate start, LocalDate end);
}
