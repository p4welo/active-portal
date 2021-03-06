package pl.ap.dao;

import pl.ap.domain.Customer;
import pl.ap.domain.Ticket;

/**
 * Created by parado on 2015-01-14.
 */
public interface ITicketDao extends IIdentifiableDao<Ticket> {
    Customer findCustomerByCode(String code);

    Ticket findByCode(String code);
}
