package pl.ap.service;

import pl.ap.domain.Customer;
import pl.ap.domain.Ticket;

/**
 * Created by parado on 2015-01-14.
 */
public interface ITicketService extends IIdentifiableService<Ticket> {
    Customer findCustomerByCode(String code);
}
