package pl.ap.dao;

import pl.ap.domain.Course;
import pl.ap.domain.CourseStyle;
import pl.ap.domain.Customer;
import pl.ap.domain.Instructor;

import java.util.List;

/**
 * Created by parado on 19.03.14.
 */
public interface ICourseDao extends IIdentifiableDao<Course> {
    List<Course> findForSchedule();

    List<Course> findInProgress();

    List<Course> findRegistration();

    List<Course> findActiveByInstructor(Instructor instructor);

    List<Course> findJoinableForCustomer(Customer customer);

    List<Course> findRegisterableForCustomer(Customer customer);

    List<Course> findActiveByStyle(CourseStyle style);
}
