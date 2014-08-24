package pl.ap.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.DanceClass;
import pl.ap.server.api.CompanyApiMappings;
import pl.ap.service.IDanceClassService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-08-24.
 */
@Controller
public class DanceClassController
{
   @Resource
   private IDanceClassService danceClassService;

   @RequestMapping(value = CompanyApiMappings.GET_DANCE_CLASS_LIST, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public List<DanceClass> getDanceClassList()
   {
      return danceClassService.findAll();
   }

   @RequestMapping(value = CompanyApiMappings.CREATE_DANCE_CLASS, method = RequestMethod.POST)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public DanceClass createDanceClass(@RequestBody DanceClass danceClass)
   {
      Assert.notNull(danceClass.getStyle());
      Assert.notNull(danceClass.getInstructor());
      Assert.notNull(danceClass.getRoom());
      return danceClassService.save(danceClass);
   }
}
