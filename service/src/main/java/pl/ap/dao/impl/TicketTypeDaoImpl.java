package pl.ap.dao.impl;

import org.springframework.stereotype.Repository;
import pl.ap.dao.ITicketTypeDao;
import pl.ap.domain.TicketType;

/**
 * Created by parado on 2015-03-04.
 */
@Repository(TicketTypeDaoImpl.BEAN_NAME)
public class TicketTypeDaoImpl extends IdentifiableDaoImpl<TicketType> implements ITicketTypeDao {

    public static final String BEAN_NAME = "ticketTypeDao";
}
