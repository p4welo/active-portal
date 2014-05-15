package co.radomski.setenta.portal.controller;

import co.radomski.setenta.domain.*;
import co.radomski.setenta.portal.api.ApiKeys;
import co.radomski.setenta.portal.api.PublicApiMappings;
import co.radomski.setenta.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by parado on 13.04.14.
 */
@Controller
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
   private ICategoryService categoryService;

   @Resource
   private IDanceClassService danceClassService;

   @RequestMapping(value = PublicApiMappings.GET_CATEGORIES, method = RequestMethod.GET)
   @ResponseBody
   public List<Category> getCategories()
   {
      return categoryService.findAll();
   }

   @RequestMapping(value = PublicApiMappings.GET_CLASSES, method = RequestMethod.GET)
   @ResponseBody
   public List<DanceClass> getClasses()
   {
      return danceClassService.findScheduleClasses();
   }

   @RequestMapping(value = PublicApiMappings.GET_FUTURE_CLASSES, method = RequestMethod.GET)
   @ResponseBody
   public List<DanceClass> getFutureClasses()
   {
      return danceClassService.findFutureClasses();
   }

   @RequestMapping(value = PublicApiMappings.SEND_EMAIL, method = RequestMethod.POST)
   @ResponseBody
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
   @ResponseBody
   public List<Instructor> getInstructors()
   {
      return instructorService.findAll();
   }

   @RequestMapping(value = PublicApiMappings.GET_INSTRUCTOR_DESCRIPTION, method = RequestMethod.GET)
   @ResponseBody
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
   @ResponseBody
   public List<News> getNewsList()
   {
      return newsService.findNewsList();
   }

   @RequestMapping(value = PublicApiMappings.GET_NEWS, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public News getNews(@PathVariable(ApiKeys.SID) String sid)
   {
      return newsService.getBySid(sid);
   }
}
