package co.radomski.setenta.service;

import co.radomski.setenta.domain.DanceClass;

import java.util.List;

/**
 * Created by parado on 19.03.14.
 */
public interface IDanceClassService extends IAbstractService<DanceClass>
{
   List<DanceClass> findScheduleClasses();

   List<DanceClass> findFutureClasses();
}
