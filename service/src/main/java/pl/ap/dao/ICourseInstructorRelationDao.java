package pl.ap.dao;

import pl.ap.domain.Course;
import pl.ap.domain.CourseInstructorRelation;
import pl.ap.domain.Instructor;

import java.util.List;

/**
 * Created by parado on 2015-02-05.
 */
public interface ICourseInstructorRelationDao extends IAbstractDao<CourseInstructorRelation> {
    List<Course> findActiveCoursesByInstructor(Instructor instructor);
}
