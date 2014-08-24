package pl.ap.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Instructor;
import pl.ap.server.api.ApiKeys;
import pl.ap.server.api.CompanyApiMappings;
import pl.ap.service.IInstructorService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-08-24.
 */
@Controller
public class InstructorController
{
   @Resource
   private IInstructorService instructorService;

   @RequestMapping(value = CompanyApiMappings.GET_INSTRUCTOR_LIST, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public List<Instructor> getRoomList()
   {
      return instructorService.findAll();
   }

   @RequestMapping(value = CompanyApiMappings.CREATE_INSTRUCTOR, method = RequestMethod.POST)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public Instructor createRoom(@RequestBody Instructor instructor)
   {
      return instructorService.save(instructor);
   }

   @RequestMapping(value = CompanyApiMappings.GET_INSTRUCTOR, method = RequestMethod.PUT)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public Instructor updateRoom(@RequestBody Instructor instructor, @PathVariable(ApiKeys.SID) String sid)
   {
      Instructor oldInstructor = instructorService.getBySid(sid);
      Assert.notNull(oldInstructor);
      Assert.notNull(instructor);
      Assert.isTrue(sid.equals(instructor.getSid()));

      return instructorService.update(instructor);
   }
}
