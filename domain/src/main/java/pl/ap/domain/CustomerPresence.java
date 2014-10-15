package pl.ap.domain;

/**
 * Created by parado on 2014-09-24.
 */
public class CustomerPresence {
    private Customer customer;

    private CourseUnit lesson;

    private boolean present;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CourseUnit getLesson() {
        return lesson;
    }

    public void setLesson(CourseUnit lesson) {
        this.lesson = lesson;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}
