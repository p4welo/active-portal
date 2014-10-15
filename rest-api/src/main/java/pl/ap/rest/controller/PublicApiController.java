package pl.ap.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.*;
import pl.ap.rest.api.ApiKeys;
import pl.ap.rest.api.PublicApiMappings;
import pl.ap.service.*;

import javax.annotation.Resource;
import javax.mail.MessagingException;
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
    private IMailService mailService;

    @Resource
    private ICourseCategoryService categoryService;

    @Resource
    private ICourseService danceClassService;

    @RequestMapping(value = PublicApiMappings.GET_CATEGORIES, method = RequestMethod.GET)
    public List<CourseCategory> getCategories() {
        LOGGER.info("getCategories()");
        return categoryService.findAll();
    }

    @RequestMapping(value = PublicApiMappings.GET_CLASSES, method = RequestMethod.GET)
    public List<Course> getClasses() {
        LOGGER.info("getClasses()");
        return danceClassService.findScheduleClasses();
    }

    @RequestMapping(value = PublicApiMappings.GET_FUTURE_CLASSES, method = RequestMethod.GET)
    public List<Course> getFutureClasses() {
        LOGGER.info("getFutureClasses()");
        return danceClassService.findRegistration();
    }

    @RequestMapping(value = PublicApiMappings.SEND_EMAIL, method = RequestMethod.POST)
    public Object sendMail(@RequestParam(ApiKeys.PHONE) String phone,
                           @RequestParam(ApiKeys.EMAIL) String from,
                           @RequestParam(ApiKeys.CONTENT) String content) throws MessagingException {
        LOGGER.info("sendMail()");
        String[] recipiens = new String[]{
                "p4welo@gmail.com"
              /*,
              "barbara18karpinska@interia.pl"*/
        };
        Email email = new Email(from, recipiens, "[SETENTA] Wiadomość ze strony internetowej",
                content + "<br/><br/>Telefon: " + phone + "<br/><br/>Email: " + from);
//      TODO: email storage handlers
        mailService.sendEmail(email);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = PublicApiMappings.GET_INSTRUCTORS, method = RequestMethod.GET)
    public List<Instructor> getInstructors() {
        LOGGER.info("getInstructors()");
        return instructorService.findAll();
    }

    @RequestMapping(value = PublicApiMappings.GET_INSTRUCTOR_DESCRIPTION, method = RequestMethod.GET)
    public InstructorDescription getDescription(@PathVariable String sid) {
        LOGGER.info("getDescription()");
        Instructor instructor = instructorService.getBySid(sid);
        if (instructor != null) {
            return instructorDescriptionService.getDescriptionByInstructor(instructor);
        }
        return null;
    }

    @RequestMapping(value = PublicApiMappings.GET_NEWS_LIST, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<News> getNewsList() {
        LOGGER.info("getNewsList()");
        return newsService.findPublic();
    }

    @RequestMapping(value = PublicApiMappings.GET_NEWS, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public News getNews(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("getNews()");
        return newsService.getBySid(sid);
    }
}
