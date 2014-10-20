package pl.ap.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pl.ap.dao.INewsDao;
import pl.ap.domain.News;
import pl.ap.domain.enums.ObjectStateEnum;

import java.util.List;

/**
 * Created by parado on 25.03.14.
 */
@Repository(NewsDaoImpl.BEAN_NAME)
public class NewsDaoImpl extends IdentifiableDaoImpl<News> implements INewsDao {
    public static final String BEAN_NAME = "newsDao";

    @Override
    public List<News> findNewsList() {
        Criteria criteria = createCriteria();
        criteria.addOrder(Order.desc(News.FIELD_CREATED_AT));
        return criteria.list();
    }

    @Override
    public List<News> findPublic() {
        Criteria criteria = createCriteria();
        criteria.addOrder(Order.desc(News.FIELD_CREATED_AT));
        criteria.add(Restrictions.eq(News.FIELD_OBJECT_STATE, ObjectStateEnum.ACTIVE));
        return criteria.list();
    }
}
