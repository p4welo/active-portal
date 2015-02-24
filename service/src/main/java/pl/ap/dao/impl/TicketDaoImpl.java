package pl.ap.dao.impl;

import org.springframework.stereotype.Repository;
import pl.ap.dao.ITicketDao;
import pl.ap.domain.Ticket;

/**
 * Created by parado on 2015-01-14.
 */
@Repository(TicketDaoImpl.BEAN_NAME)
public class TicketDaoImpl extends IdentifiableDaoImpl<Ticket> implements ITicketDao {

    public static final String BEAN_NAME = "ticketDao";
}
