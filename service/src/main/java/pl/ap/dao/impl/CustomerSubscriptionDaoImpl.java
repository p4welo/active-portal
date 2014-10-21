package pl.ap.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional(readOnly = true)
    public List<Course> findCoursesByCustomer(Customer customer) {
        Criteria criteria = createCriteria()
                .add(Restrictions.eq(CustomerSubscription.FIELD_CUSTOMER, customer))
                .createAlias(CustomerSubscription.FIELD_COURSE, CustomerSubscription.FIELD_COURSE)
                .addOrder(Order.asc(CustomerSubscription.FIELD_COURSE + "." + Course.FIELD_DAY))
                .addOrder(Order.asc(CustomerSubscription.FIELD_COURSE + "." + Course.FIELD_START_TIME))
                .setProjection(Projections.property(CustomerSubscription.FIELD_COURSE));
        return criteria.list();
    }
}
