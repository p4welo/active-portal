package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.ITicketTypeGroupDao;
import pl.ap.domain.TicketTypeGroup;
import pl.ap.service.ITicketTypeGroupService;

import javax.annotation.Resource;

/**
 * Created by parado on 2015-02-25.
 */
@Service(TicketTypeGroupServiceImpl.BEAN_NAME)
public class TicketTypeGroupServiceImpl extends IdentifiableServiceImpl<TicketTypeGroup> implements ITicketTypeGroupService {

    public static final String BEAN_NAME = "ticketTypeGroupService";

    @Resource
    private ITicketTypeGroupDao ticketTypeGroupDao;

    @Override
    protected IIdentifiableDao<TicketTypeGroup> getDao() {
        return ticketTypeGroupDao;
    }

    @Override
    protected String[] getUpdateFields() {
        return new String[] {
                TicketTypeGroup.FIELD_NAME,
                TicketTypeGroup.FIELD_OBJECT_STATE
        };
    }
}
