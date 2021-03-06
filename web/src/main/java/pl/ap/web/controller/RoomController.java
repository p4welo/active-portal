package pl.ap.web.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Room;
import pl.ap.web.api.ApiKeys;
import pl.ap.web.api.CommonApiMappings;
import pl.ap.web.api.RoomApiMappings;
import pl.ap.service.IRoomService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-08-24.
 */
@RestController
@RequestMapping(value = CommonApiMappings.REST_PREFIX)
public class RoomController extends AbstractController {
    private static final Logger LOGGER = Logger.getLogger(RoomController.class);

    @Resource
    private IRoomService roomService;

    @RequestMapping(value = RoomApiMappings.FIND_ALL, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Room> findAll() {
        LOGGER.info("findAll()");
        return roomService.findAll();
    }

    @RequestMapping(value = RoomApiMappings.CREATE, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Room create(@RequestBody Room room) {
        LOGGER.info("create()");
        assertNotNull(room, "room");
        return roomService.save(room);
    }

    @RequestMapping(value = RoomApiMappings.GET, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Room get(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("get()");
        return roomService.getBySid(sid);
    }

    @RequestMapping(value = RoomApiMappings.ACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Room activate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("activate()");
        Room room = roomService.getBySid(sid);
        assertSidObject(room);
        return roomService.activate(room);
    }

    @RequestMapping(value = RoomApiMappings.DEACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Room deactivate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("deactivate()");
        Room room = roomService.getBySid(sid);
        assertSidObject(room);
        return roomService.deactivate(room);
    }

    @RequestMapping(value = RoomApiMappings.UPDATE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Room update(@RequestBody Room room, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("update()");
        assertSidObject(roomService.getBySid(sid));
        assertNotNull(room, "room");
        Assert.isTrue(sid.equals(room.getSid()));
        return roomService.update(room);
    }

    @RequestMapping(value = RoomApiMappings.DELETE, method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("delete()");
        Room room = roomService.getBySid(sid);
        assertSidObject(room);
        roomService.delete(room);
    }
}