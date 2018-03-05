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
        ticket.setPurchaseDate(new DateTime());
        ticket.setType(ticketData.getType());
        ticket.setEntrancesUsed(0);
        ticket.setCustomer(customer);

        save(ticket);
    }

    @Override
    @Transactional(readOnly = true)
    public Ticket findByCode(String code) {
        return ticketDao.findByCode(code);
    }
}
