package pl.ap.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Instructor;
import pl.ap.rest.api.ApiKeys;
import pl.ap.rest.api.CompanyApiMappings;
import pl.ap.rest.api.InstructorApiMappings;
import pl.ap.service.IInstructorService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-08-24.
 */
@RestController
public class InstructorController
{
   private static final Logger LOGGER = Logger.getLogger(InstructorController.class);

   @Resource
   private IInstructorService instructorService;

   @RequestMapping(value = InstructorApiMappings.FIND_ALL, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   public List<Instructor> findAll()
   {
      LOGGER.info("findAll()");
      return instructorService.findAll();
   }

   @RequestMapping(value = InstructorApiMappings.CREATE, method = RequestMethod.POST)
   @ResponseStatus(value = HttpStatus.OK)
   public Instructor create(@RequestBody Instructor instructor)
   {
      LOGGER.info("create()");
      return instructorService.save(instructor);
   }

   @RequestMapping(value = InstructorApiMappings.UPDATE, method = RequestMethod.PUT)
   @ResponseStatus(value = HttpStatus.OK)
   public Instructor update(@RequestBody Instructor instructor, @PathVariable(ApiKeys.SID) String sid)
   {
      LOGGER.info("update()");
      Instructor oldInstructor = instructorService.getBySid(sid);
      Assert.notNull(oldInstructor);
      Assert.notNull(instructor);
      Assert.isTrue(sid.equals(instructor.getSid()));

      return instructorService.update(instructor);
   }
}
