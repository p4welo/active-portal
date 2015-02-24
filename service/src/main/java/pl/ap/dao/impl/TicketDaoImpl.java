package pl.ap.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pl.ap.dao.ITicketDao;
import pl.ap.domain.Customer;
import pl.ap.domain.Ticket;

/**
 * Created by parado on 2015-01-14.
 */
@Repository(TicketDaoImpl.BEAN_NAME)
public class TicketDaoImpl extends IdentifiableDaoImpl<Ticket> implements ITicketDao {

    public static final String BEAN_NAME = "ticketDao";

    @Override
    public Customer findCustomerByCode(String code) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq(Ticket.FIELD_BARCODE, code));
        criteria.setProjection(Projections.property(Ticket.FIELD_CUSTOMER));
        criteria.setMaxResults(1);
        return (Customer) criteria.uniqueResult();
    }
}
