package pl.ap.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pl.ap.dao.IUserDao;
import pl.ap.domain.User;

/**
 * Created by parado on 08.04.14.
 */
@Repository(UserDaoImpl.BEAN_NAME)
public class UserDaoImpl extends AbstractDaoImpl<User> implements IUserDao {
    public static final String BEAN_NAME = "userDao";

    @Override
    public User getByLogin(String login) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq(User.FIELD_LOGIN, login));
        criteria.setMaxResults(1);
        return (User) criteria.uniqueResult();
    }
}
