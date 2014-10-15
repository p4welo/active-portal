package pl.ap.domain;

import org.joda.time.DateTime;

/**
 * Created by parado on 2014-09-24.
 */
public class CourseUnit {
    private Course course;

    private DateTime dateTime;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }
}
