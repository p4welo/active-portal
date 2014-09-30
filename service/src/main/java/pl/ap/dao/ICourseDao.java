package pl.ap.dao;

import pl.ap.domain.Course;

import java.util.List;

/**
 * Created by parado on 19.03.14.
 */
public interface ICourseDao extends IAbstractDao<Course>
{
   List<Course> findScheduleClasses();

   List<Course> findFutureClasses();
}
