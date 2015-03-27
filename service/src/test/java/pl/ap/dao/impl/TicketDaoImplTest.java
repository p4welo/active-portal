package pl.ap.dao.impl;

import org.junit.Before;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.ITicketDao;
import pl.ap.factory.TestDomainObjectFactory;
import pl.ap.domain.Customer;
import pl.ap.domain.Ticket;
import pl.ap.domain.TicketType;
import pl.ap.domain.TicketTypeGroup;

import javax.annotation.Resource;

/**
 * Created by parado on 2015-01-14.
 */
public class TicketDaoImplTest extends IdentifiableDaoImplTest<Ticket> {

    @Resource
    private ITicketDao ticketDao;

    private Customer customer;

    private TicketType type;

    @Override
    protected IIdentifiableDao<Ticket> getDao() {
        return ticketDao;
    }

    @Before
    public void setup() {
        customer = TestDomainObjectFactory.getCustomer();
        persist(customer);
        TicketTypeGroup group = TestDomainObjectFactory.getTicketTypeGroup();
        persist(group);
        type = TestDomainObjectFactory.getTicketType(group);
        persist(type);
    }

    @Override
    protected Ticket getEntity() {
        return TestDomainObjectFactory.getTicket(customer, type);
    }
}
