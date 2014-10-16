package pl.ap.dao.impl;

import pl.ap.dao.ICustomerDao;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.TestDomainObjectFactory;
import pl.ap.domain.Customer;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-16.
 */
public class CustomerDaoImplTest extends IdentifiableDaoImplTest<Customer> {
    @Resource
    private ICustomerDao customerDao;

    @Override
    protected IIdentifiableDao<Customer> getDao() {
        return customerDao;
    }

    @Override
    protected Customer getEntity() {
        return TestDomainObjectFactory.getCustomer();
    }
}
