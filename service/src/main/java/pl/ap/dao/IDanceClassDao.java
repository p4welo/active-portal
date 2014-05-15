package pl.ap.dao;

import pl.ap.domain.DanceClass;

import java.util.List;

/**
 * Created by parado on 19.03.14.
 */
public interface IDanceClassDao extends IAbstractDao<DanceClass>
{
   List<DanceClass> findScheduleClasses();

   List<DanceClass> findFutureClasses();
}
