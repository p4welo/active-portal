package pl.ap.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Room;
import pl.ap.server.api.ApiKeys;
import pl.ap.server.api.CompanyApiMappings;
import pl.ap.service.IRoomService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-08-24.
 */
@Controller
public class RoomController
{
   @Resource
   private IRoomService roomService;

   @RequestMapping(value = CompanyApiMappings.GET_ROOM_LIST, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public List<Room> getRoomList()
   {
      return roomService.findAll();
   }

   @RequestMapping(value = CompanyApiMappings.CREATE_ROOM, method = RequestMethod.POST)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public Room createRoom(@RequestBody Room room)
   {
      return roomService.save(room);
   }

   @RequestMapping(value = CompanyApiMappings.GET_ROOM, method = RequestMethod.PUT)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public Room updateRoom(@RequestBody Room room, @PathVariable(ApiKeys.SID) String sid)
   {
      Room oldRoom = roomService.getBySid(sid);
      Assert.notNull(oldRoom);
      Assert.notNull(room);
      Assert.isTrue(sid.equals(room.getSid()));

      return roomService.update(room);
   }
}
