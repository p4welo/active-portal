package pl.ap.dao.impl;

import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.ITicketTypeGroupDao;
import pl.ap.factory.TestDomainObjectFactory;
import pl.ap.domain.TicketTypeGroup;

import javax.annotation.Resource;

/**
 * Created by parado on 2015-02-25.
 */
public class TicketTypeGroupDaoImplTest extends IdentifiableDaoImplTest<TicketTypeGroup> {

    @Resource
    private ITicketTypeGroupDao ticketTypeGroupDao;

    @Override
    protected IIdentifiableDao<TicketTypeGroup> getDao() {
        return ticketTypeGroupDao;
    }

    @Override
    protected TicketTypeGroup getEntity() {
        return TestDomainObjectFactory.getTicketTypeGroup();
    }
}
