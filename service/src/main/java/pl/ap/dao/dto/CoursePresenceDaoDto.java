package pl.ap.dao.dto;

import org.joda.time.DateTime;
import pl.ap.domain.Customer;

/**
 * Created by parado on 2014-11-16.
 */
public class CoursePresenceDaoDto {
    private Customer customer;

    private DateTime lesson;

    private boolean present;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public DateTime getLesson() {
        return lesson;
    }

    public void setLesson(DateTime lesson) {
        this.lesson = lesson;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}
