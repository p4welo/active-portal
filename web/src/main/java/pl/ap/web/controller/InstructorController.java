package pl.ap.web.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Course;
import pl.ap.domain.Instructor;
import pl.ap.web.api.ApiKeys;
import pl.ap.web.api.CommonApiMappings;
import pl.ap.web.api.InstructorApiMappings;
import pl.ap.service.IInstructorService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-08-24.
 */
@RestController
@RequestMapping(value = CommonApiMappings.REST_PREFIX)
public class InstructorController extends AbstractController {
    private static final Logger LOGGER = Logger.getLogger(InstructorController.class);

    @Resource
    private IInstructorService instructorService;

    @RequestMapping(value = InstructorApiMappings.FIND_ALL, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Instructor> findAll() {
        LOGGER.info("findAll()");
        return instructorService.findAll();
    }

    @RequestMapping(value = InstructorApiMappings.CREATE, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Instructor create(@RequestBody Instructor instructor) {
        LOGGER.info("create()");
        return instructorService.save(instructor);
    }

    @RequestMapping(value = InstructorApiMappings.GET, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Instructor get(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("get()");
        Instructor instructor = instructorService.getBySid(sid);
        assertSidObject(instructor);
        return instructor;
    }

    @RequestMapping(value = InstructorApiMappings.ACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Instructor activate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("activate()");
        Instructor instructor = instructorService.getBySid(sid);
        assertSidObject(instructor);
        return instructorService.activate(instructor);
    }

    @RequestMapping(value = InstructorApiMappings.DEACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Instructor deactivate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("deactivate()");
        Instructor instructor = instructorService.getBySid(sid);
        assertSidObject(instructor);
        return instructorService.deactivate(instructor);
    }

    @RequestMapping(value = InstructorApiMappings.UPDATE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Instructor update(@RequestBody Instructor instructor, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("update()");
        assertSidObject(instructorService.getBySid(sid));
        assertNotNull(instructor, "instructor");
        assertSidIntegrity(instructor, sid);
        return instructorService.update(instructor);
    }

    @RequestMapping(value = InstructorApiMappings.DELETE, method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("delete()");
        Instructor instructor = instructorService.getBySid(sid);
        assertSidObject(instructor);
        instructorService.delete(instructor);
    }

    @RequestMapping(value = InstructorApiMappings.COURSES, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Course> findCourses(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("findCourses()");
        Instructor instructor = instructorService.getBySid(sid);
        assertSidObject(instructor);
        return instructorService.findCourses(instructor);
    }
}
