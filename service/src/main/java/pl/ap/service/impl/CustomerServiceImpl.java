package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Override
    @Transactional(readOnly = false)
    public Customer activate(Customer customer) {
//      TODO: change customer status
        return customerDao.update(customer);
    }

    @Override
    @Transactional(readOnly = false)
    public Customer deactivate(Customer customer) {
        //      TODO: change customer status
        return customerDao.update(customer);
    }
}
