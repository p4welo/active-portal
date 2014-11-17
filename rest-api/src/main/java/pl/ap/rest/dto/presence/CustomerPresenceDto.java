package pl.ap.rest.dto.presence;

import org.joda.time.DateTime;
import pl.ap.domain.Customer;

import java.util.Map;

/**
 * Created by parado on 2014-11-03.
 */
public class CustomerPresenceDto {

    private Customer customer;

    private Map<DateTime, Boolean> presence;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Map<DateTime, Boolean> getPresence() {
        return presence;
    }

    public void setPresence(Map<DateTime, Boolean> presence) {
        this.presence = presence;
    }
}
