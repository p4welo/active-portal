package pl.ap.dao.impl;

import org.springframework.stereotype.Repository;
import pl.ap.dao.ICustomerSubscriptionDao;
import pl.ap.domain.CustomerSubscription;

/**
 * Created by parado on 2014-10-17.
 */
@Repository(CustomerSubscriptionDaoImpl.BEAN_NAME)
public class CustomerSubscriptionDaoImpl extends AbstractDaoImpl<CustomerSubscription> implements ICustomerSubscriptionDao {
    public static final String BEAN_NAME = "customerSubscriptionDao";
}
