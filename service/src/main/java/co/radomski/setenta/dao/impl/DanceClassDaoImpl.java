package co.radomski.setenta.dao.impl;

import co.radomski.setenta.dao.IDanceClassDao;
import co.radomski.setenta.domain.DanceClass;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by parado on 19.03.14.
 */
@Repository(DanceClassDaoImpl.BEAN_NAME)
public class DanceClassDaoImpl extends AbstractDaoImpl<DanceClass> implements IDanceClassDao
{
   public static final String BEAN_NAME = "danceClassDao";

   @Override
   public List<DanceClass> findScheduleClasses()
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(DanceClass.FIELD_IN_PROGRESS, true));
      criteria.addOrder(Order.asc(DanceClass.FIELD_START_TIME));
      return criteria.list();
   }

   @Override
   public List<DanceClass> findFutureClasses()
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(DanceClass.FIELD_IN_PROGRESS, false));
      criteria.addOrder(Order.asc(DanceClass.FIELD_DAY));
      criteria.addOrder(Order.asc(DanceClass.FIELD_START_TIME));
      return criteria.list();
   }
}
