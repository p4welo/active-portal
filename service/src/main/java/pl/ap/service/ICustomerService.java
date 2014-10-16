package pl.ap.service;

import pl.ap.domain.Customer;

/**
 * Created by parado on 2014-10-16.
 */
public interface ICustomerService extends IIdentifiableService<Customer> {
    Customer activate(Customer customer);

    Customer deactivate(Customer customer);
}
