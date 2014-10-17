package pl.ap.dao.impl;

import org.springframework.stereotype.Repository;
import pl.ap.dao.ICustomerPresenceDao;
import pl.ap.domain.CustomerPresence;

/**
 * Created by parado on 2014-10-17.
 */
@Repository(CustomerPresenceDaoImpl.BEAN_NAME)
public class CustomerPresenceDaoImpl extends AbstractDaoImpl<CustomerPresence> implements ICustomerPresenceDao {
    public static final String BEAN_NAME = "customerPresence";
}
