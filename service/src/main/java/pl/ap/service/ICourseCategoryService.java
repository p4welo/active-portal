package pl.ap.service;

import pl.ap.domain.CourseCategory;

/**
 * Created by parado on 19.03.14.
 */
public interface ICourseCategoryService extends IIdentifiableService<CourseCategory> {
    CourseCategory activate(CourseCategory category);

    CourseCategory deactivate(CourseCategory category);
}
