package pl.ap.web.dto;

import pl.ap.domain.enums.CourseStateEnum;

/**
 * Created by parado on 2014-10-15.
 */
public class CourseStateDto {
    CourseStateEnum state;

    public CourseStateEnum getState() {
        return state;
    }

    public void setState(CourseStateEnum state) {
        this.state = state;
    }
}
