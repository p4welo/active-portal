package pl.ap.rest.dto.presence;

import pl.ap.domain.CourseUnit;

import java.util.List;

/**
 * Created by parado on 2014-11-03.
 */
public class CoursePresenceDto {
    private List<CourseUnit> lessons;
    private List<CoursePresenceDto> customerPresence;

    public List<CourseUnit> getLessons() {
        return lessons;
    }

    public void setLessons(List<CourseUnit> lessons) {
        this.lessons = lessons;
    }

    public List<CoursePresenceDto> getCustomerPresence() {
        return customerPresence;
    }

    public void setCustomerPresence(List<CoursePresenceDto> customerPresence) {
        this.customerPresence = customerPresence;
    }
}
