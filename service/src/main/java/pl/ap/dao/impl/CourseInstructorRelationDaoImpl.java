package pl.ap.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pl.ap.dao.ICourseInstructorRelationDao;
import pl.ap.domain.Course;
import pl.ap.domain.CourseInstructorRelation;
import pl.ap.domain.Instructor;

import java.util.List;

/**
 * Created by parado on 2015-02-05.
 */
@Repository(CourseInstructorRelationDaoImpl.BEAN_NAME)
public class CourseInstructorRelationDaoImpl extends AbstractDaoImpl<CourseInstructorRelation> implements ICourseInstructorRelationDao {
    public static final String BEAN_NAME = "courseInstructorRelationDao";

    @Override
    public List<Course> findActiveCoursesByInstructor(Instructor instructor) {
        Criteria criteria = createCriteria()
                .add(Restrictions.eq(CourseInstructorRelation.FIELD_INSTRUCTOR, instructor))
                .setProjection(Projections.property(CourseInstructorRelation.FIELD_COURSE));
        return criteria.list();
    }
}
