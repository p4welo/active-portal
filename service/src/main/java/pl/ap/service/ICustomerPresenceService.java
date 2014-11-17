package pl.ap.service;

import pl.ap.domain.Course;
import pl.ap.domain.Customer;
import pl.ap.domain.CustomerPresence;

import java.util.List;
import java.util.Map;

/**
 * Created by parado on 2014-10-17.
 */
public interface ICustomerPresenceService extends IAbstractService<CustomerPresence> {
    Map<Customer, List<CustomerPresence>> findLastByCourse(Course course, int maxResults);
}
