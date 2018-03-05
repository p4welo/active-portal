package pl.ap.service;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import pl.ap.domain.Event;

import java.util.List;

/**
 * Created by parado on 2015-05-11.
 */
public interface IEventService extends IIdentifiableService<Event> {
    List<Event> findByDateRange(LocalDate start, LocalDate end);
}
