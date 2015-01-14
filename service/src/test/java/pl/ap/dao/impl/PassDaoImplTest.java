package pl.ap.dao.impl;

import org.junit.Before;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.IPassDao;
import pl.ap.dao.TestDomainObjectFactory;
import pl.ap.domain.Customer;
import pl.ap.domain.Pass;

import javax.annotation.Resource;

/**
 * Created by parado on 2015-01-14.
 */
public class PassDaoImplTest extends IdentifiableDaoImplTest<Pass> {

    @Resource
    private IPassDao passDao;

    private Customer customer;

    @Override
    protected IIdentifiableDao<Pass> getDao() {
        return passDao;
    }

    @Before
    public void setup() {
        customer = TestDomainObjectFactory.getCustomer();
        persist(customer);
    }

    @Override
    protected Pass getEntity() {
        return TestDomainObjectFactory.getPass(customer);
    }
}
