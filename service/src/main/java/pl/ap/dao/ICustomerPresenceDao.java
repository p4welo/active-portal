package pl.ap.dao;

import pl.ap.dao.dto.CoursePresenceDaoDto;
import pl.ap.domain.Course;
import pl.ap.domain.CourseUnit;
import pl.ap.domain.Customer;
import pl.ap.domain.CustomerPresence;

import java.util.List;

/**
 * Created by parado on 2014-10-17.
 */
public interface ICustomerPresenceDao extends IAbstractDao<CustomerPresence> {
    List<CustomerPresence> findByCustomer(Customer customer);

    List<CoursePresenceDaoDto> findByCourse(Course course);

//    List<CustomerPresence> findByLessons(List<CourseUnit> lessons);
}
