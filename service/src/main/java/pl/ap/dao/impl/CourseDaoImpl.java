package pl.ap.dao.impl;

import pl.ap.dao.ICourseDao;
import pl.ap.domain.Course;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by parado on 19.03.14.
 */
@Repository(CourseDaoImpl.BEAN_NAME)
public class CourseDaoImpl extends AbstractDaoImpl<Course> implements ICourseDao
{
   public static final String BEAN_NAME = "courseDao";

   @Override
   public List<Course> findScheduleClasses()
   {
      Criteria criteria = createCriteria();
//      criteria.add(Restrictions.eq(DanceClass.FIELD_IN_PROGRESS, true));
      criteria.addOrder(Order.asc(Course.FIELD_START_TIME));
      return criteria.list();
   }

   @Override
   public List<Course> findFutureClasses()
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(Course.FIELD_IN_PROGRESS, false));
      criteria.addOrder(Order.asc(Course.FIELD_DAY));
      criteria.addOrder(Order.asc(Course.FIELD_START_TIME));
      return criteria.list();
   }
}
