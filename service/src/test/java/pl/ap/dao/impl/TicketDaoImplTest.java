package pl.ap.dao.impl;

import org.junit.Before;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.ITicketDao;
import pl.ap.dao.TestDomainObjectFactory;
import pl.ap.domain.Customer;
import pl.ap.domain.Ticket;

import javax.annotation.Resource;

/**
 * Created by parado on 2015-01-14.
 */
public class TicketDaoImplTest extends IdentifiableDaoImplTest<Ticket> {

    @Resource
    private ITicketDao passDao;

    private Customer customer;

    @Override
    protected IIdentifiableDao<Ticket> getDao() {
        return passDao;
    }

    @Before
    public void setup() {
        customer = TestDomainObjectFactory.getCustomer();
        persist(customer);
    }

    @Override
    protected Ticket getEntity() {
        return TestDomainObjectFactory.getPass(customer);
    }
}
