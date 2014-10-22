package pl.ap.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Course;
import pl.ap.domain.Instructor;
import pl.ap.domain.Room;
import pl.ap.rest.api.ApiKeys;
import pl.ap.rest.api.CourseApiMappings;
import pl.ap.rest.dto.CourseStateDto;
import pl.ap.service.ICourseService;
import pl.ap.service.IInstructorService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-08-24.
 */
@RestController
public class CourseController {
    private static final Logger LOGGER = Logger.getLogger(CourseController.class);

    @Resource
    private ICourseService courseService;

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

        Assert.notNull(course);
        Assert.notNull(course.getStyle());
        Assert.notNull(course.getRoom());

        return courseService.save(course);
    }

    @RequestMapping(value = CourseApiMappings.GET, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Course get(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("get()");
        return courseService.getBySid(sid);
    }

    @RequestMapping(value = CourseApiMappings.PUBLISH, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Course publish(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("publish()");

        Course course = courseService.getBySid(sid);
        Assert.notNull(course);

        return courseService.publish(course);
    }

    @RequestMapping(value = CourseApiMappings.DEACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Course deactivate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("deactivate()");

        Course course = courseService.getBySid(sid);
        Assert.notNull(course);

        return courseService.deactivate(course);
    }

    @RequestMapping(value = CourseApiMappings.UPDATE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Course update(@RequestBody Course course, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("update()");

        Assert.notNull(courseService.getBySid(sid));
        Assert.notNull(course);
        Assert.isTrue(sid.equals(course.getSid()));

        return courseService.update(course);
    }

    @RequestMapping(value = CourseApiMappings.DELETE, method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    @Secured("hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("delete()");

        Course course = courseService.getBySid(sid);
        Assert.notNull(course);

        courseService.delete(course);
    }

    @RequestMapping(value = CourseApiMappings.SET_STATE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Course setState(@RequestBody CourseStateDto stateDto, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("setState()");

        Course course = courseService.getBySid(sid);
        Assert.notNull(course);
        Assert.notNull(stateDto);

        return courseService.setState(course, stateDto.getState());
    }

    @RequestMapping(value = CourseApiMappings.SET_INSTRUCTOR, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Course setInstructor(@RequestBody Instructor instructor, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("setInstructor()");

        Course course = courseService.getBySid(sid);
        Assert.notNull(course);
        Assert.notNull(instructor);

        return courseService.setInstructor(course, instructor);
    }

    @RequestMapping(value = CourseApiMappings.SET_ROOM, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Course setRoom(@RequestBody Room room, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("setRoom()");

        Course course = courseService.getBySid(sid);
        Assert.notNull(course);
        Assert.notNull(room);

        return courseService.setRoom(course, room);
    }
}