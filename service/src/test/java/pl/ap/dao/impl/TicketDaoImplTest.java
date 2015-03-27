package pl.ap.dao.impl;

import org.junit.Before;
import org.junit.Test;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.ITicketDao;
import pl.ap.factory.TestDomainObjectFactory;
import pl.ap.domain.Customer;
import pl.ap.domain.Ticket;
import pl.ap.domain.TicketType;
import pl.ap.domain.TicketTypeGroup;

import javax.annotation.Resource;
import java.util.List;
import static org.junit.Assert.*;

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

    @Test
    public void testFindCustomerByCode() {
        List<Ticket> list = getEntities();
        persist(list);
        Ticket ticket = list.get(0);
        Customer result = ticketDao.findCustomerByCode(ticket.getBarcode());
        assertNotNull(result);
        assertEquals(ticket.getCustomer(), result);
    }

    @Test
    public void testFindByCode() {
        List<Ticket> list = getEntities();
        persist(list);
        Ticket ticket = list.get(0);
        Ticket result = ticketDao.findByCode(ticket.getBarcode());
        assertNotNull(result);
        assertEquals(ticket, result);
    }

    @Override
    protected Ticket getEntity() {
        return TestDomainObjectFactory.getTicket(customer, type);
    }
}
