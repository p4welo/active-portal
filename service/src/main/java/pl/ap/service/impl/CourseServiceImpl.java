package pl.ap.service.impl;

import pl.ap.dao.IAbstractDao;
import pl.ap.dao.ICourseDao;
import pl.ap.domain.Course;
import pl.ap.domain.Instructor;
import pl.ap.domain.Room;
import pl.ap.domain.Style;
import pl.ap.service.ICourseService;
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
@Service(CourseServiceImpl.BEAN_NAME)
public class CourseServiceImpl extends AbstractServiceImpl<Course> implements ICourseService
{
   public static final String BEAN_NAME = "danceClassService";

   @Resource
   private ICourseDao danceClassDao;

   @Resource
   private IInstructorService instructorService;

   @Resource
   private IStyleService styleService;

   @Resource
   private IRoomService roomService;

   @Override
   protected IAbstractDao<Course> getDao()
   {
      return danceClassDao;
   }

   @Override
   @Transactional(readOnly = true)
   public List<Course> findScheduleClasses()
   {
      return danceClassDao.findScheduleClasses();
   }

   @Override
   @Transactional(readOnly = true)
   public List<Course> findFutureClasses()
   {
      return danceClassDao.findFutureClasses();
   }

   @Override
   @Transactional(readOnly = false)
   public Course save(Course course)
   {
      Style style = styleService.getBySid(course.getStyle().getSid());
      course.setStyle(style);
      Instructor oldInstructor = course.getInstructor();
      if (oldInstructor  != null) {
         Instructor instructor = instructorService.getBySid(course.getInstructor().getSid());
         course.setInstructor(instructor);
      }
      Room room = roomService.getBySid(course.getRoom().getSid());
      course.setRoom(room);
      return super.save(course);
   }
}
