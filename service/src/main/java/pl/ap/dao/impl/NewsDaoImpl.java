package pl.ap.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import pl.ap.dao.INewsDao;
import pl.ap.domain.News;

import java.util.List;

/**
 * Created by parado on 25.03.14.
 */
@Repository(NewsDaoImpl.BEAN_NAME)
public class NewsDaoImpl extends AbstractDaoImpl<News> implements INewsDao {
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
//        TODO: add status restriction
        return criteria.list();
    }
}
