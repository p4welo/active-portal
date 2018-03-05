package pl.ap.web.dto;

import pl.ap.domain.Course;
import pl.ap.domain.Customer;

import java.util.List;

/**
 * Created by parado on 2015-01-14.
 */
public class CustomerDto {
    private Customer customer;

    private List<Course> courses;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
