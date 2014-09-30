package pl.ap.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Course;
import pl.ap.server.api.ApiKeys;
import pl.ap.server.api.CompanyApiMappings;
import pl.ap.service.ICourseService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-08-24.
 */
@Controller
public class DanceClassController
{
   @Resource
   private ICourseService danceClassService;

   @RequestMapping(value = CompanyApiMappings.GET_DANCE_CLASS_LIST, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public List<Course> getDanceClassList()
   {
      return danceClassService.findAll();
   }

   @RequestMapping(value = CompanyApiMappings.CREATE_DANCE_CLASS, method = RequestMethod.POST)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public Course createDanceClass(@RequestBody Course course)
   {
      Assert.notNull(course.getStyle());
//      Assert.notNull(danceClass.getInstructor());
      Assert.notNull(course.getRoom());
      return danceClassService.save(course);
   }

   @RequestMapping(value = CompanyApiMappings.GET_DANCE_CLASS, method = RequestMethod.PUT)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public Course updateDanceClass(@RequestBody Course course, @PathVariable(ApiKeys.SID) String sid)
   {
      Course oldCourse = danceClassService.getBySid(sid);
      Assert.notNull(oldCourse);
      Assert.notNull(course);
      Assert.isTrue(sid.equals(course.getSid()));

      return danceClassService.update(course);
   }
}
