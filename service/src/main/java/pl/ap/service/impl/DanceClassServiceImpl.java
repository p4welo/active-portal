package pl.ap.service.impl;

import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IDanceClassDao;
import pl.ap.domain.DanceClass;
import pl.ap.service.IDanceClassService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 19.03.14.
 */
@Service(DanceClassServiceImpl.BEAN_NAME)
public class DanceClassServiceImpl extends AbstractServiceImpl<DanceClass> implements IDanceClassService
{
   public static final String BEAN_NAME = "danceClassService";

   @Resource
   private IDanceClassDao danceClassDao;

   @Override
   protected IAbstractDao<DanceClass> getDao()
   {
      return danceClassDao;
   }

   @Override
   @Transactional(readOnly = true)
   public List<DanceClass> findScheduleClasses()
   {
      return danceClassDao.findScheduleClasses();
   }

   @Override
   @Transactional(readOnly = true)
   public List<DanceClass> findFutureClasses()
   {
      return danceClassDao.findFutureClasses();
   }
}
