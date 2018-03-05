package pl.ap.service;

import pl.ap.domain.Course;
import pl.ap.domain.CourseCategory;
import pl.ap.domain.CourseStyle;

import java.util.List;

/**
 * Created by parado on 19.03.14.
 */
public interface ICourseStyleService extends IIdentifiableService<CourseStyle> {
    CourseStyle setCategory(CourseStyle style, CourseCategory category);

    List<Course> findActiveByStyle(CourseStyle style);
}
