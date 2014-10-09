package pl.ap.rest.controller;

import org.springframework.http.HttpStatus;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Room;
import pl.ap.rest.api.ApiKeys;
import pl.ap.rest.api.CompanyApiMappings;
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

   @RequestMapping(value = CompanyApiMappings.GET_ROOM_LIST, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   public List<Room> getRoomList()
   {
      LOGGER.info("getRoomList()");
      return roomService.findAll();
   }

   @RequestMapping(value = CompanyApiMappings.CREATE_ROOM, method = RequestMethod.POST)
   @ResponseStatus(value = HttpStatus.OK)
   public Room createRoom(@RequestBody Room room)
   {
      LOGGER.info("createRoom()");
      return roomService.save(room);
   }

   @RequestMapping(value = CompanyApiMappings.GET_ROOM, method = RequestMethod.PUT)
   @ResponseStatus(value = HttpStatus.OK)
   public Room updateRoom(@RequestBody Room room, @PathVariable(ApiKeys.SID) String sid)
   {
      LOGGER.info("updateRoom()");
      Room oldRoom = roomService.getBySid(sid);
      Assert.notNull(oldRoom);
      Assert.notNull(room);
      Assert.isTrue(sid.equals(room.getSid()));

      return roomService.update(room);
   }
}
