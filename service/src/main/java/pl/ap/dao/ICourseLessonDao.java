package pl.ap.dao;

import pl.ap.domain.Course;
import pl.ap.domain.CourseLesson;

import java.util.List;

/**
 * Created by parado on 2014-10-16.
 */
public interface ICourseLessonDao extends IAbstractDao<CourseLesson> {
    List<CourseLesson> findLastByCourse(Course course, int maxResults);
}
