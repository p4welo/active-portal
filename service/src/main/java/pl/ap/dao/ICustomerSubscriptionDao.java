package pl.ap.dao;

import pl.ap.domain.Course;
import pl.ap.domain.Customer;
import pl.ap.domain.CustomerSubscription;

import java.util.List;

/**
 * Created by parado on 2014-10-17.
 */
public interface ICustomerSubscriptionDao extends IAbstractDao<CustomerSubscription> {
    List<Course> findCoursesByCustomer(Customer customer);
}
