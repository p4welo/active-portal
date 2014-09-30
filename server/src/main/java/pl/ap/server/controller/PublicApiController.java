package pl.ap.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.*;
import pl.ap.server.api.ApiKeys;
import pl.ap.server.api.PublicApiMappings;
import pl.ap.service.*;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by parado on 13.04.14.
 */
@RestController
public class PublicApiController
{
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
   public List<CourseCategory> getCategories()
   {
      return categoryService.findAll();
   }

   @RequestMapping(value = PublicApiMappings.GET_CLASSES, method = RequestMethod.GET)
   public List<Course> getClasses()
   {
      return danceClassService.findScheduleClasses();
   }

   @RequestMapping(value = PublicApiMappings.GET_FUTURE_CLASSES, method = RequestMethod.GET)
   public List<Course> getFutureClasses()
   {
      return danceClassService.findFutureClasses();
   }

   @RequestMapping(value = PublicApiMappings.SEND_EMAIL, method = RequestMethod.POST)
   public Object sendMail(@RequestParam(ApiKeys.PHONE) String phone,
                          @RequestParam(ApiKeys.EMAIL) String from,
                          @RequestParam(ApiKeys.CONTENT) String content) throws MessagingException
   {
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
   public List<Instructor> getInstructors()
   {
      return instructorService.findAll();
   }

   @RequestMapping(value = PublicApiMappings.GET_INSTRUCTOR_DESCRIPTION, method = RequestMethod.GET)
   public InstructorDescription getDescription(@PathVariable String sid)
   {
      Instructor instructor = instructorService.getBySid(sid);
      if (instructor != null)
      {
         return instructorDescriptionService.getDescriptionByInstructor(instructor);
      }
      return null;
   }

   @RequestMapping(value = PublicApiMappings.GET_NEWS_LIST, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   public List<News> getNewsList()
   {
      return newsService.findNewsList();
   }

   @RequestMapping(value = PublicApiMappings.GET_NEWS, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   public News getNews(@PathVariable(ApiKeys.SID) String sid)
   {
      return newsService.getBySid(sid);
   }
}
