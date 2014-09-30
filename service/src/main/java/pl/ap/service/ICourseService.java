package pl.ap.service;

import pl.ap.domain.Course;

import java.util.List;

/**
 * Created by parado on 19.03.14.
 */
public interface ICourseService extends IAbstractService<Course>
{
   List<Course> findScheduleClasses();

   List<Course> findFutureClasses();
}
