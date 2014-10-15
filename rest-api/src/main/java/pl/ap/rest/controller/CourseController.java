package pl.ap.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Course;
import pl.ap.rest.api.ApiKeys;
import pl.ap.rest.api.CourseApiMappings;
import pl.ap.service.ICourseService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-08-24.
 */
@RestController
public class CourseController
{
   private static final Logger LOGGER = Logger.getLogger(CourseController.class);

   @Resource
   private ICourseService courseService;

   @RequestMapping(value = CourseApiMappings.FIND_ALL, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   public List<Course> findAll()
   {
      LOGGER.info("findAll()");
      return courseService.findAll();
   }

   @RequestMapping(value = CourseApiMappings.FIND_IN_PROGRESS, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   public List<Course> findInProgress()
   {
      LOGGER.info("findInProgress()");
//      TODO: prepare service call
      return courseService.findAll();
   }

   @RequestMapping(value = CourseApiMappings.FIND_REGISTRATION, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   public List<Course> findRegistration()
   {
      LOGGER.info("findRegistration()");
//      TODO: prepare service call
      return courseService.findAll();
   }

   @RequestMapping(value = CourseApiMappings.CREATE, method = RequestMethod.POST)
   @ResponseStatus(value = HttpStatus.OK)
   public Course create(@RequestBody Course course)
   {
      LOGGER.info("create()");
      Assert.notNull(course.getStyle());
      Assert.notNull(course.getRoom());
      return courseService.save(course);
   }

   @RequestMapping(value = CourseApiMappings.UPDATE, method = RequestMethod.PUT)
   @ResponseStatus(value = HttpStatus.OK)
   public Course update(@RequestBody Course course, @PathVariable(ApiKeys.SID) String sid)
   {
      LOGGER.info("update()");
      Course oldCourse = courseService.getBySid(sid);
      Assert.notNull(oldCourse);
      Assert.notNull(course);
      Assert.isTrue(sid.equals(course.getSid()));

      return courseService.update(course);
   }
}
