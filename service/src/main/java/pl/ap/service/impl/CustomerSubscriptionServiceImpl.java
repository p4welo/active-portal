package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.ICustomerSubscriptionDao;
import pl.ap.domain.CustomerSubscription;
import pl.ap.service.ICustomerSubscriptionService;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-17.
 */
@Service(CustomerSubscriptionServiceImpl.BEAN_NAME)
public class CustomerSubscriptionServiceImpl extends AbstractServiceImpl<CustomerSubscription> implements ICustomerSubscriptionService {
    public static final String BEAN_NAME = "customerSubscriptionService";

    @Resource
    private ICustomerSubscriptionDao customerSubscriptionDao;

    @Override
    protected IAbstractDao<CustomerSubscription> getDao() {
        return customerSubscriptionDao;
    }
}
