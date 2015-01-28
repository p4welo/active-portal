package pl.ap.dao.impl;

import org.springframework.stereotype.Repository;
import pl.ap.dao.ICustomerContactDataDao;
import pl.ap.domain.CustomerContactData;

/**
 * Created by parado on 2015-01-28.
 */
@Repository(CustomerContactDataDaoImpl.BEAN_NAME)
public class CustomerContactDataDaoImpl extends AbstractDaoImpl<CustomerContactData> implements ICustomerContactDataDao {
    public static final String BEAN_NAME = "customerContactDataDao";
}
