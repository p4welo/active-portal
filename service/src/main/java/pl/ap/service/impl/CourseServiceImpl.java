package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.ICourseDao;
import pl.ap.domain.Course;
import pl.ap.domain.CourseStyle;
import pl.ap.domain.Instructor;
import pl.ap.domain.Room;
import pl.ap.domain.enums.CourseStateEnum;
import pl.ap.service.ICourseService;
import pl.ap.service.ICourseStyleService;
import pl.ap.service.IInstructorService;
import pl.ap.service.IRoomService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 19.03.14.
 */
@Service(CourseServiceImpl.BEAN_NAME)
public class CourseServiceImpl extends AbstractServiceImpl<Course> implements ICourseService {
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
    protected IAbstractDao<Course> getDao() {
        return courseDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findScheduleClasses() {
        return courseDao.findScheduleClasses();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findFutureClasses() {
        return courseDao.findFutureClasses();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findInProgress() {
        return courseDao.findInProgress();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findRegistration() {
        return courseDao.findRegistration();
    }

    @Override
    @Transactional(readOnly = false)
    public Course publish(Course course) {
//        TODO: change course state
        return courseDao.update(course);
    }

    @Override
    @Transactional(readOnly = false)
    public Course deactivate(Course course) {
//        TODO: change course state
        return courseDao.update(course);
    }

    @Override
    @Transactional(readOnly = false)
    public Course setInstructor(Course course, Instructor instructor) {
        instructor = instructorService.getBySid(instructor.getSid());
        course.setInstructor(instructor);
        return courseDao.update(course);
    }

    @Override
    @Transactional(readOnly = false)
    public Course setRoom(Course course, Room room) {
        room = roomService.getBySid(room.getSid());
        course.setRoom(room);
        return courseDao.update(course);
    }

    @Override
    @Transactional(readOnly = false)
    public Course setState(Course course, CourseStateEnum state) {
        if (state == null) {
            return course;
        }
        else if (state == CourseStateEnum.REGISTRATION) {
            course.setCanRegister(true);
            course.setInProgress(false);
            course.setCanJoin(false);
        }
        else if (state == CourseStateEnum.CAN_JOIN) {
            course.setCanRegister(false);
            course.setInProgress(true);
            course.setCanJoin(true);
        }
        else if (state == CourseStateEnum.NO_PLACE) {
            course.setCanRegister(false);
            course.setInProgress(true);
            course.setCanJoin(false);
        }
        return courseDao.update(course);
    }

    @Override
    @Transactional(readOnly = false)
    public Course save(Course course) {
        CourseStyle courseStyle = styleService.getBySid(course.getStyle().getSid());
        course.setStyle(courseStyle);
        Instructor oldInstructor = course.getInstructor();
        if (oldInstructor != null) {
            Instructor instructor = instructorService.getBySid(oldInstructor.getSid());
            course.setInstructor(instructor);
        }
        Room room = roomService.getBySid(course.getRoom().getSid());
        course.setRoom(room);
        return super.save(course);
    }
}
