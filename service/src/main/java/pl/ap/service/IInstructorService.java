package pl.ap.service;

import pl.ap.domain.Course;
import pl.ap.domain.Instructor;

import java.util.List;

/**
 * Created by parado on 19.03.14.
 */
public interface IInstructorService extends IAbstractService<Instructor> {
    Instructor activate(Instructor instructor);

    Instructor deactivate(Instructor instructor);

    List<Course> findCourses(Instructor instructor);
}
