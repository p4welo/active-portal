package pl.ap.domain;

/**
 * Created by parado on 2014-09-24.
 */
public class CustomerSubscription {
    private Customer customer;

    private Course course;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
