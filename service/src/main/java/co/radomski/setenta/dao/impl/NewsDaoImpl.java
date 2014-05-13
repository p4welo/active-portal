package co.radomski.setenta.dao.impl;

import co.radomski.setenta.dao.INewsDao;
import co.radomski.setenta.domain.News;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by parado on 25.03.14.
 */
@Repository(NewsDaoImpl.BEAN_NAME)
public class NewsDaoImpl extends AbstractDaoImpl<News> implements INewsDao
{
   public static final String BEAN_NAME = "newsDao";

   @Override
   public List<News> findNewsList()
   {
      Criteria criteria = createCriteria();
      criteria.addOrder(Order.desc(News.FIELD_CREATED_AT));
      return criteria.list();
   }
}
