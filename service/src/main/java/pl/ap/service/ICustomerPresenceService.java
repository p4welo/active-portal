package pl.ap.service;

import pl.ap.domain.Course;
import pl.ap.domain.CustomerPresence;

import java.util.List;

/**
 * Created by parado on 2014-10-17.
 */
public interface ICustomerPresenceService extends IAbstractService<CustomerPresence> {
    List<CustomerPresence> findLastByCourse(Course course, int maxResults);
}
