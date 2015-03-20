package pl.ap.service.impl;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.ITicketDao;
import pl.ap.domain.Customer;
import pl.ap.domain.Ticket;
import pl.ap.domain.enums.TicketTypeEnum;
import pl.ap.service.ITicketService;

import javax.annotation.Resource;

/**
 * Created by parado on 2015-01-14.
 */
@Service(TicketServiceImpl.BEAN_NAME)
public class TicketServiceImpl extends IdentifiableServiceImpl<Ticket> implements ITicketService {

    public static final String BEAN_NAME = "ticketService";

    @Resource
    private ITicketDao ticketDao;


    @Override
    protected IIdentifiableDao<Ticket> getDao() {
        return ticketDao;
    }

    @Override
    protected String[] getUpdateFields() {
        return new String[] {
                Ticket.FIELD_ENTRANCES_USED,
                Ticket.FIELD_OBJECT_STATE
        };
    }

    @Override
    @Transactional(readOnly = true)
    public Customer findCustomerByCode(String code) {
        return ticketDao.findCustomerByCode(code);
    }

    @Override
    @Transactional(readOnly = false)
    public void buy(Customer customer, Ticket ticketData) {
        Ticket ticket = new Ticket();
        ticket.setBarcode(ticketData.getBarcode());
        TicketTypeEnum type = ticketData.getType();
        ticket.setType(type);
        ticket.setPurchaseDate(new DateTime());
        int pool = 0;
        switch (type) {
            case ADULT_1_ENTRANCE:
                pool = 1;
                break;
            case ADULT_4_ENTRANCES_MONTH:
                pool = 4;
                break;
            case ADULT_8_ENTRANCES_MONTH:
                pool = 8;
                break;
            case ADULT_OPEN_MONTH:
                pool = -1;
                break;
            case CHILD_1_ENTRANCE:
                pool = 1;
                break;
            case CHILD_4_ENTRANCES_MONTH:
                pool = 4;
                break;
            case CHILD_8_ENTRANCES_MONTH:
                pool = 8;
                break;
            case CHILD_OPEN_MONTH:
                pool = -1;
                break;
            case CHILD_FORMATION_MONTH:
                pool = -1;
                break;
        }
        ticket.setEntrancesUsed(0);
        ticket.setEntrancePool(pool);
        ticket.setCustomer(customer);

        save(ticket);
    }

    @Override
    @Transactional(readOnly = true)
    public Ticket findByCode(String code) {
        return ticketDao.findByCode(code);
    }
}
