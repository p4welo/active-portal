package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.ITicketTypeDao;
import pl.ap.domain.TicketType;
import pl.ap.domain.TicketTypeGroup;
import pl.ap.service.ITicketTypeGroupService;
import pl.ap.service.ITicketTypeService;

import javax.annotation.Resource;

/**
 * Created by parado on 2015-03-04.
 */
@Service(TicketTypeServiceImpl.BEAN_NAME)
public class TicketTypeServiceImpl extends IdentifiableServiceImpl<TicketType> implements ITicketTypeService {

    public static final String BEAN_NAME = "ticketTypeService";

    @Resource
    private ITicketTypeDao ticketTypeDao;

    @Resource
    private ITicketTypeGroupService ticketTypeGroupService;

    @Override
    protected IIdentifiableDao<TicketType> getDao() {
        return ticketTypeDao;
    }

    @Override
    @Transactional(readOnly = false)
    public TicketType save(TicketType type) {
        TicketTypeGroup group = ticketTypeGroupService.getBySid(type.getGroup().getSid());
        type.setGroup(group);
        return super.save(type);
    }

    @Override
    protected String[] getUpdateFields() {
        return new String[] {
                TicketType.FIELD_OBJECT_STATE,
                TicketType.FIELD_ENTRANCE_POOL,
                TicketType.FIELD_PERIOD_AMOUNT,
                TicketType.FIELD_PERIOD_TYPE,
                TicketType.FIELD_GROUP,
                TicketType.FIELD_NAME,
                TicketType.FIELD_PRICE
        };
    }
}
