package pl.ap.service;

import pl.ap.domain.Course;
import pl.ap.domain.Customer;
import pl.ap.domain.CustomerPresence;

import java.util.List;

/**
 * Created by parado on 2014-10-16.
 */
public interface ICustomerService extends IIdentifiableService<Customer> {
    Customer activate(Customer customer);

    Customer deactivate(Customer customer);

    List<CustomerPresence> findPresence(Customer customer);

    List<Course> findCourses(Customer customer);
}
