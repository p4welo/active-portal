package pl.ap.dao.impl;

import org.springframework.stereotype.Repository;
import pl.ap.dao.ICustomerDao;
import pl.ap.domain.Customer;

/**
 * Created by parado on 2014-10-16.
 */
@Repository(CustomerDaoImpl.BEAN_NAME)
public class CustomerDaoImpl extends IdentifiableDaoImpl<Customer> implements ICustomerDao {
    public static final String BEAN_NAME = "customerDao";
}