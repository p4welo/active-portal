package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.ITicketTypeDao;
import pl.ap.domain.TicketType;
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

    @Override
    protected IIdentifiableDao<TicketType> getDao() {
        return ticketTypeDao;
    }

    @Override
    protected String[] getUpdateFields() {
        return new String[] {
                TicketType.FIELD_OBJECT_STATE,
                TicketType.FIELD_ENTRANCE_POOL,
                TicketType.FIELD_PERIOD_AMOUNT,
                TicketType.FIELD_PERIOD_TYPE,
                TicketType.FIELD_GROUP,
                TicketType.FIELD_PRICE
        };
    }
}
