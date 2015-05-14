package pl.ap.web.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.*;
import pl.ap.domain.enums.CourseStateEnum;
import pl.ap.service.*;
import pl.ap.web.api.ApiKeys;
import pl.ap.web.api.CourseApiMappings;
import pl.ap.web.dto.CourseStateDto;
import pl.ap.web.dto.SidListDto;
import pl.ap.web.dto.presence.CoursePresenceDto;
import pl.ap.web.exceptions.InvalidParameterException;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by parado on 2014-08-24.
 */
@RestController
public class CourseController extends AbstractController {
    private static final Logger LOGGER = Logger.getLogger(CourseController.class);

    @Resource
    private ICourseService courseService;

    @Resource
    private IInstructorService instructorService;

    @Resource
    private ICustomerPresenceService customerPresenceService;

    @Resource
    private ICourseLessonService courseUnitService;

    @Resource
    private ICustomerService customerService;

    @RequestMapping(value = CourseApiMappings.FIND_ALL, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Course> findAll() {
        LOGGER.info("findAll()");
        return courseService.findAll();
    }

    @RequestMapping(value = CourseApiMappings.FIND_IN_PROGRESS, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Course> findInProgress() {
        LOGGER.info("findInProgress()");
        return courseService.findInProgress();
    }

    @RequestMapping(value = CourseApiMappings.FIND_REGISTRATION, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Course> findRegistration() {
        LOGGER.info("findRegistration()");
        return courseService.findRegistration();
    }

    @RequestMapping(value = CourseApiMappings.CREATE, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Course create(@RequestBody Course course) {
        LOGGER.info("create()");

        assertNotNull(course, "course");
        assertNotNull(course.getStyle(), "style");
        assertNotNull(course.getRoom(), "room");

        if (course.getCourseState() == CourseStateEnum.REGISTRATION) {
            course.setCanRegister(true);
            course.setCanJoin(false);
            course.setInProgress(false);
        } else if (course.getCourseState() == CourseStateEnum.CAN_JOIN) {
            course.setCanRegister(false);
            course.setCanJoin(true);
            course.setInProgress(true);
        }
        else {
            course.setCanRegister(false);
            course.setCanJoin(false);
            course.setInProgress(true);
        }

        return courseService.save(course);
    }

    @RequestMapping(value = CourseApiMappings.GET, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Course get(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("get()");
        Course course = courseService.getBySid(sid);
        assertSidObject(course);
        return course;
    }

    @RequestMapping(value = CourseApiMappings.PUBLISH, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Course publish(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("publish()");

        Course course = courseService.getBySid(sid);
        assertSidObject(course);

        return courseService.publish(course);
    }

    @RequestMapping(value = CourseApiMappings.DEACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Course deactivate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("deactivate()");

        Course course = courseService.getBySid(sid);
        assertSidObject(course);

        return courseService.deactivate(course);
    }

    @RequestMapping(value = CourseApiMappings.UPDATE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Course update(@RequestBody Course course, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("update()");

        assertSidObject(courseService.getBySid(sid));
        assertNotNull(course, "course");
        assertSidIntegrity(course, sid);

        return courseService.update(course);
    }



    @RequestMapping(value = CourseApiMappings.DELETE, method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("delete()");

        Course course = courseService.getBySid(sid);
        assertSidObject(course);
        courseService.delete(course);
    }

    @RequestMapping(value = CourseApiMappings.SET_STATE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Course setState(@RequestBody CourseStateDto stateDto, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("setState()");

        Course course = courseService.getBySid(sid);
        assertSidObject(course);
        assertNotNull(stateDto, "dto");

        return courseService.setState(course, stateDto.getState());
    }

    @RequestMapping(value = CourseApiMappings.SET_INSTRUCTOR, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Course setInstructor(@RequestBody Instructor instructor, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("setInstructor()");

        Course course = courseService.getBySid(sid);
        assertSidObject(course);
        assertNotNull(instructor, "instructor");

        return courseService.setInstructor(course, instructor);
    }

    @RequestMapping(value = CourseApiMappings.REASSIGN_INSTRUCTORS, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Course reassignInstructors(@RequestBody SidListDto instructorSidsDto, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("reassignInstructors()");

        Course course = courseService.getBySid(sid);
        assertSidObject(course);
        assertNotNull(instructorSidsDto, "dto");
        assertNotNull(instructorSidsDto.getSids(), "instructors");

        List<Instructor> instructors = instructorService.findBySids(instructorSidsDto.getSids());
        Assert.notEmpty(instructors);

        return courseService.reassignInstructors(course, instructors);
    }

    @RequestMapping(value = CourseApiMappings.SET_STYLE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Course setStyle(@RequestBody CourseStyle style, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("setCategory()");

        Course course = courseService.getBySid(sid);
        assertSidObject(course);
        assertNotNull(style, "style");

        return courseService.setStyle(course, style);
    }

    @RequestMapping(value = CourseApiMappings.SET_ROOM, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Course setRoom(@RequestBody Room room, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("setRoom()");


        Course course = courseService.getBySid(sid);
        assertSidObject(course);
        assertNotNull(room, "room");

        return courseService.setRoom(course, room);
    }

    @RequestMapping(value = CourseApiMappings.FIND_LAST_PRESENCE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public CoursePresenceDto findCoursePresence(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("findCoursePresence()");

        Course course = new Course();//courseService.getBySid(sid);
        assertSidObject(course);

        Map<Customer, List<CustomerPresence>> presences = customerPresenceService.findLastByCourse(course, 10);

        return null;
    }

    @RequestMapping(value = CourseApiMappings.FIND_LESSONS, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<CourseLesson> findLessons(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("findLessons()");

        Course course = courseService.getBySid(sid);
        assertSidObject(course);

        return courseUnitService.findBy(CourseLesson.FIELD_COURSE, course);
    }

    @RequestMapping(value = CourseApiMappings.FIND_CUSTOMERS, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Customer> findCustomers(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("findCustomers()");

        Course course = courseService.getBySid(sid);
        assertSidObject(course);

        return customerService.findByCourse(course);
    }
}