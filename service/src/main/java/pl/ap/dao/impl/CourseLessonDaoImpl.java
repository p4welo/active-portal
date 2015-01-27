package pl.ap.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pl.ap.dao.ICourseLessonDao;
import pl.ap.domain.Course;
import pl.ap.domain.CourseLesson;

import java.util.List;

/**
 * Created by parado on 2014-10-16.
 */
@Repository(CourseLessonDaoImpl.BEAN_NAME)
public class CourseLessonDaoImpl extends AbstractDaoImpl<CourseLesson> implements ICourseLessonDao {
    public static final String BEAN_NAME = "courseLessonDao";

    @Override
    public List<CourseLesson> findLastByCourse(Course course, int maxResults) {
        Criteria criteria = createCriteria()
                .add(Restrictions.eq(CourseLesson.FIELD_COURSE, course))
                .addOrder(Order.desc(CourseLesson.FIELD_DATE_TIME))
                .setMaxResults(maxResults);
        return criteria.list();
    }
}
