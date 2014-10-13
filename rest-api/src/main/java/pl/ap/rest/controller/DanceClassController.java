package pl.ap.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Course;
import pl.ap.rest.api.ApiKeys;
import pl.ap.rest.api.CompanyApiMappings;
import pl.ap.service.ICourseService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-08-24.
 */
@RestController
public class DanceClassController
{
   private static final Logger LOGGER = Logger.getLogger(DanceClassController.class);

   @Resource
   private ICourseService danceClassService;

   @RequestMapping(value = CompanyApiMappings.GET_ALL_DANCE_CLASS_LIST, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   public List<Course> getDanceClassList()
   {
      LOGGER.info("getDanceClassList()");
      return danceClassService.findAll();
   }

   @RequestMapping(value = CompanyApiMappings.GET_DANCE_CLASS_IN_PROGRESS_LIST, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   public List<Course> getDanceClassInProgressList()
   {
      LOGGER.info("getDanceClassInProgressList()");
//      TODO: prepare service call
      return danceClassService.findAll();
   }

   @RequestMapping(value = CompanyApiMappings.GET_DANCE_CLASS_TO_REGISTER_LIST, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   public List<Course> getDanceClassToRegisterList()
   {
      LOGGER.info("getDanceClassToRegisterList()");
//      TODO: prepare service call
      return danceClassService.findAll();
   }

   @RequestMapping(value = CompanyApiMappings.CREATE_DANCE_CLASS, method = RequestMethod.POST)
   @ResponseStatus(value = HttpStatus.OK)
   public Course createDanceClass(@RequestBody Course course)
   {
      LOGGER.info("createDanceClass()");
      Assert.notNull(course.getStyle());
      Assert.notNull(course.getRoom());
      return danceClassService.save(course);
   }

   @RequestMapping(value = CompanyApiMappings.GET_DANCE_CLASS, method = RequestMethod.PUT)
   @ResponseStatus(value = HttpStatus.OK)
   public Course updateDanceClass(@RequestBody Course course, @PathVariable(ApiKeys.SID) String sid)
   {
      LOGGER.info("updateDanceClass()");
      Course oldCourse = danceClassService.getBySid(sid);
      Assert.notNull(oldCourse);
      Assert.notNull(course);
      Assert.isTrue(sid.equals(course.getSid()));

      return danceClassService.update(course);
   }
}
