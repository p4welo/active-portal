package pl.ap.web.dto.presence;

import pl.ap.domain.CourseLesson;

import java.util.List;

/**
 * Created by parado on 2014-11-03.
 */
public class CoursePresenceDto {
    private List<CourseLesson> lessons;
    private List<CoursePresenceDto> customerPresence;

    public List<CourseLesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<CourseLesson> lessons) {
        this.lessons = lessons;
    }

    public List<CoursePresenceDto> getCustomerPresence() {
        return customerPresence;
    }

    public void setCustomerPresence(List<CoursePresenceDto> customerPresence) {
        this.customerPresence = customerPresence;
    }
}
