package pl.ap.dao.impl;

import org.junit.Before;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.ITicketTypeDao;
import pl.ap.factory.TestDomainObjectFactory;
import pl.ap.domain.TicketType;
import pl.ap.domain.TicketTypeGroup;

import javax.annotation.Resource;

/**
 * Created by parado on 2015-03-26.
 */
public class TicketTypeDaoImplTest extends IdentifiableDaoImplTest<TicketType> {

    @Resource
    private ITicketTypeDao ticketTypeDao;

    private TicketTypeGroup group;

    @Override
    protected IIdentifiableDao<TicketType> getDao() {
        return ticketTypeDao;
    }

    @Before
    public void setup() {
        group = TestDomainObjectFactory.getTicketTypeGroup();
        persist(group);
    }

    @Override
    protected TicketType getEntity() {
        return TestDomainObjectFactory.getTicketType(group);
    }
}
