package pl.ap.dao.impl;

import org.springframework.stereotype.Repository;
import pl.ap.dao.ITicketTypeGroupDao;
import pl.ap.domain.TicketTypeGroup;

/**
 * Created by parado on 2015-02-25.
 */
@Repository(TicketTypeGroupDaoImpl.BEAN_NAME)
public class TicketTypeGroupDaoImpl extends IdentifiableDaoImpl<TicketTypeGroup> implements ITicketTypeGroupDao {

    public static final String BEAN_NAME = "ticketTypeGroupDao";
}
