package pl.ap.service;

import pl.ap.domain.Course;
import pl.ap.domain.CourseStyle;
import pl.ap.domain.Instructor;
import pl.ap.domain.Room;
import pl.ap.domain.enums.CourseStateEnum;

import java.util.List;

/**
 * Created by parado on 19.03.14.
 */
public interface ICourseService extends IIdentifiableService<Course> {
    List<Course> findForSchedule();

    List<Course> findInProgress();

    List<Course> findRegistration();

    Course publish(Course course);

    Course deactivate(Course course);

    Course setInstructor(Course course, Instructor instructor);

    Course setRoom(Course course, Room room);

    Course setState(Course course, CourseStateEnum state);
}
