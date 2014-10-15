package pl.ap.rest.controller;

import org.springframework.http.HttpStatus;
import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Room;
import pl.ap.rest.api.ApiKeys;
import pl.ap.rest.api.CompanyApiMappings;
import pl.ap.rest.api.RoomApiMappings;
import pl.ap.service.IRoomService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-08-24.
 */
@RestController
public class RoomController
{
   private static final Logger LOGGER = Logger.getLogger(RoomController.class);

   @Resource
   private IRoomService roomService;

   @RequestMapping(value = RoomApiMappings.FIND_ALL, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   public List<Room> findAll()
   {
      LOGGER.info("findAll()");
      return roomService.findAll();
   }

   @RequestMapping(value = RoomApiMappings.CREATE, method = RequestMethod.POST)
   @ResponseStatus(value = HttpStatus.OK)
   public Room create(@RequestBody Room room)
   {
      LOGGER.info("create()");
      return roomService.save(room);
   }

   @RequestMapping(value = RoomApiMappings.UPDATE, method = RequestMethod.PUT)
   @ResponseStatus(value = HttpStatus.OK)
   public Room update(@RequestBody Room room, @PathVariable(ApiKeys.SID) String sid)
   {
      LOGGER.info("update()");
      Room oldRoom = roomService.getBySid(sid);
      Assert.notNull(oldRoom);
      Assert.notNull(room);
      Assert.isTrue(sid.equals(room.getSid()));

      return roomService.update(room);
   }
}
