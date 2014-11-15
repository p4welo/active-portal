package pl.ap.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pl.ap.dao.ICourseUnitDao;
import pl.ap.domain.Course;
import pl.ap.domain.CourseUnit;

import java.util.List;

/**
 * Created by parado on 2014-10-16.
 */
@Repository(CourseUnitDaoImpl.BEAN_NAME)
public class CourseUnitDaoImpl extends AbstractDaoImpl<CourseUnit> implements ICourseUnitDao {
    public static final String BEAN_NAME = "courseUnitDao";

    @Override
    public List<CourseUnit> findLastByCourse(Course course, int maxResults) {
        Criteria criteria = createCriteria()
                .add(Restrictions.eq(CourseUnit.FIELD_COURSE, course))
                .addOrder(Order.desc(CourseUnit.FIELD_DATE_TIME))
                .setMaxResults(maxResults);
        return criteria.list();
    }
}
