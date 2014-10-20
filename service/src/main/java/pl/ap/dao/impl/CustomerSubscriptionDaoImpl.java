package pl.ap.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pl.ap.dao.ICustomerSubscriptionDao;
import pl.ap.domain.Course;
import pl.ap.domain.Customer;
import pl.ap.domain.CustomerSubscription;

import java.util.List;

/**
 * Created by parado on 2014-10-17.
 */
@Repository(CustomerSubscriptionDaoImpl.BEAN_NAME)
public class CustomerSubscriptionDaoImpl extends AbstractDaoImpl<CustomerSubscription> implements ICustomerSubscriptionDao {
    public static final String BEAN_NAME = "customerSubscriptionDao";

    @Override
    public List<Course> findCoursesByCustomer(Customer customer) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq(CustomerSubscription.FIELD_CUSTOMER, customer));
        criteria.setProjection(Projections.property(CustomerSubscription.FIELD_COURSE));
        return criteria.list();
    }
}
