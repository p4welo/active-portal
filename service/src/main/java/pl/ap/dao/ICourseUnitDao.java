package pl.ap.dao;

import pl.ap.domain.Course;
import pl.ap.domain.CourseUnit;

import java.util.List;

/**
 * Created by parado on 2014-10-16.
 */
public interface ICourseUnitDao extends IAbstractDao<CourseUnit> {
    List<CourseUnit> findLastByCourse(Course course, int maxResults);
}
