package pl.ap.publ.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.*;
import pl.ap.publ.api.PublicApiMappings;
import pl.ap.service.*;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by parado on 13.04.14.
 */
@RestController
public class PublicApiController {
    private static final Logger LOGGER = Logger.getLogger(PublicApiController.class);

    @Resource
    private INewsService newsService;

    @Resource
    private IInstructorService instructorService;

    @Resource
    private IInstructorDescriptionService instructorDescriptionService;

    @Resource
    private ICourseService courseService;

    @Resource
    private IEmailService emailService;

    @RequestMapping(value = PublicApiMappings.COURSE_LIST, method = RequestMethod.GET)
    public List<Course> courseList() {
        LOGGER.info("courseList()");
        return courseService.findForSchedule();
    }

    @RequestMapping(value = PublicApiMappings.REGISTRATION_COURSE_LIST, method = RequestMethod.GET)
    public List<Course> registrationCourseList() {
        LOGGER.info("registrationCourseList()");
        return courseService.findRegistration();
    }

    @RequestMapping(value = PublicApiMappings.INSTRUCTOR_LIST, method = RequestMethod.GET)
    public List<Instructor> instructorList() {
        LOGGER.info("instructorList()");
        return instructorService.findAll();
    }

    @RequestMapping(value = PublicApiMappings.INSTRUCTOR_DESCRIPTION, method = RequestMethod.GET)
    public InstructorDescription instructorDescription(@PathVariable String sid) {
        LOGGER.info("instructorDescription()");
        Instructor instructor = instructorService.getBySid(sid);
        if (instructor != null) {
            return instructorDescriptionService.getDescriptionByInstructor(instructor);
        }
        return null;
    }

    @RequestMapping(value = PublicApiMappings.NEWS_LIST, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<News> newsList() {
        LOGGER.info("newsList()");
        return newsService.findPublic();
    }

    @RequestMapping(value = PublicApiMappings.SEND_FEEDBACK, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void sendFeedback(@RequestBody CustomerFeedback feedback) throws MessagingException {
        LOGGER.info("sendFeedback()");

        Assert.notNull(feedback);

        emailService.customerFeedback(feedback);
    }
}
