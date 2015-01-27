package pl.ap.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import pl.ap.dao.ICustomerPresenceDao;
import pl.ap.dao.dto.CoursePresenceDaoDto;
import pl.ap.domain.Course;
import pl.ap.domain.Customer;
import pl.ap.domain.CustomerPresence;
import pl.ap.domain.CustomerSubscription;

import java.util.List;

/**
 * Created by parado on 2014-10-17.
 */
@Repository(CustomerPresenceDaoImpl.BEAN_NAME)
public class CustomerPresenceDaoImpl extends AbstractDaoImpl<CustomerPresence> implements ICustomerPresenceDao {
    public static final String BEAN_NAME = "customerPresence";

    @Override
    public List<CustomerPresence> findByCustomer(Customer customer) {
        Criteria criteria = createCriteria()
                .add(Restrictions.eq(CustomerPresence.FIELD_CUSTOMER, customer));
        return criteria.list();
    }
}
