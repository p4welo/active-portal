package pl.ap.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.DanceClass;
import pl.ap.rest.api.ApiKeys;
import pl.ap.rest.api.CompanyApiMappings;
import pl.ap.service.IDanceClassService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-08-24.
 */
@RestController
public class DanceClassController
{
   @Resource
   private IDanceClassService danceClassService;

   @RequestMapping(value = CompanyApiMappings.GET_DANCE_CLASS_LIST, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   public List<DanceClass> getDanceClassList()
   {
      return danceClassService.findAll();
   }

   @RequestMapping(value = CompanyApiMappings.CREATE_DANCE_CLASS, method = RequestMethod.POST)
   @ResponseStatus(value = HttpStatus.OK)
   public DanceClass createDanceClass(@RequestBody DanceClass danceClass)
   {
      Assert.notNull(danceClass.getStyle());
      Assert.notNull(danceClass.getRoom());
      return danceClassService.save(danceClass);
   }

   @RequestMapping(value = CompanyApiMappings.GET_DANCE_CLASS, method = RequestMethod.PUT)
   @ResponseStatus(value = HttpStatus.OK)
   public DanceClass updateDanceClass(@RequestBody DanceClass danceClass, @PathVariable(ApiKeys.SID) String sid)
   {
      DanceClass oldDanceClass = danceClassService.getBySid(sid);
      Assert.notNull(oldDanceClass);
      Assert.notNull(danceClass);
      Assert.isTrue(sid.equals(danceClass.getSid()));

      return danceClassService.update(danceClass);
   }
}
