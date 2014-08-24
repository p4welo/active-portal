package pl.ap.service.impl;

import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IDanceClassDao;
import pl.ap.domain.DanceClass;
import pl.ap.domain.Instructor;
import pl.ap.domain.Room;
import pl.ap.domain.Style;
import pl.ap.service.IDanceClassService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.service.IInstructorService;
import pl.ap.service.IRoomService;
import pl.ap.service.IStyleService;

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

   @Resource
   private IInstructorService instructorService;

   @Resource
   private IStyleService styleService;

   @Resource
   private IRoomService roomService;

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

   @Override
   @Transactional(readOnly = false)
   public DanceClass save(DanceClass danceClass)
   {
      Style style = styleService.getBySid(danceClass.getStyle().getSid());
      danceClass.setStyle(style);
      Instructor instructor = instructorService.getBySid(danceClass.getInstructor().getSid());
      danceClass.setInstructor(instructor);
      Room room = roomService.getBySid(danceClass.getRoom().getSid());
      danceClass.setRoom(room);
      return super.save(danceClass);
   }
}
