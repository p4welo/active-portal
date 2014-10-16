package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import pl.ap.dao.ICustomerDao;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.domain.Customer;
import pl.ap.service.ICustomerService;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-16.
 */
@Service
public class CustomerServiceImpl extends IdentifiableServiceImpl<Customer> implements ICustomerService {
    public static final String BEAN_NAME = "customerService";

    @Resource
    private ICustomerDao customerDao;

    @Override
    protected IIdentifiableDao<Customer> getDao() {
        return customerDao;
    }
}
