package pl.ap.service.impl;

import pl.ap.dao.IAbstractDao;
import pl.ap.dao.ICourseDao;
import pl.ap.domain.Course;
import pl.ap.domain.Instructor;
import pl.ap.domain.Room;
import pl.ap.domain.CourseStyle;
import pl.ap.service.ICourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.service.ICourseStyleService;
import pl.ap.service.IInstructorService;
import pl.ap.service.IRoomService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 19.03.14.
 */
@Service(CourseServiceImpl.BEAN_NAME)
public class CourseServiceImpl extends AbstractServiceImpl<Course> implements ICourseService
{
   public static final String BEAN_NAME = "courseService";

   @Resource
   private ICourseDao courseDao;

   @Resource
   private IInstructorService instructorService;

   @Resource
   private ICourseStyleService styleService;

   @Resource
   private IRoomService roomService;

   @Override
   protected IAbstractDao<Course> getDao()
   {
      return courseDao;
   }

   @Override
   @Transactional(readOnly = true)
   public List<Course> findScheduleClasses()
   {
      return courseDao.findScheduleClasses();
   }

   @Override
   @Transactional(readOnly = true)
   public List<Course> findFutureClasses()
   {
      return courseDao.findFutureClasses();
   }

   @Override
   @Transactional(readOnly = false)
   public Course save(Course course)
   {
      CourseStyle courseStyle = styleService.getBySid(course.getStyle().getSid());
      course.setStyle(courseStyle);
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
