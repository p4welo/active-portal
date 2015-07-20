package pl.ap.web.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.TicketTypeGroup;
import pl.ap.web.api.ApiKeys;
import pl.ap.web.api.TicketTypeGroupApiMappings;
import pl.ap.service.ITicketTypeGroupService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2015-02-28.
 */
@RestController
public class TicketTypeGroupController extends AbstractController {

    private static final Logger LOGGER = Logger.getLogger(TicketTypeGroupController.class);

    @Resource
    private ITicketTypeGroupService ticketTypeGroupService;


    @RequestMapping(value = TicketTypeGroupApiMappings.FIND_ALL, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TicketTypeGroup> findAll() {
        LOGGER.info("findAll()");
        return ticketTypeGroupService.findAll();
    }

    @RequestMapping(value = TicketTypeGroupApiMappings.CREATE, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public TicketTypeGroup create(@RequestBody TicketTypeGroup group) {
        LOGGER.info("create()");
        assertNotNull(group, "group");
        return ticketTypeGroupService.save(group);
    }

    @RequestMapping(value = TicketTypeGroupApiMappings.GET, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TicketTypeGroup get(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("get()");
        return ticketTypeGroupService.getBySid(sid);
    }

    @RequestMapping(value = TicketTypeGroupApiMappings.ACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TicketTypeGroup activate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("activate()");
        TicketTypeGroup group = ticketTypeGroupService.getBySid(sid);
        assertSidObject(group);
        return ticketTypeGroupService.activate(group);
    }

    @RequestMapping(value = TicketTypeGroupApiMappings.DEACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TicketTypeGroup deactivate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("deactivate()");
        TicketTypeGroup group = ticketTypeGroupService.getBySid(sid);
        assertSidObject(group);
        return ticketTypeGroupService.deactivate(group);
    }

    @RequestMapping(value = TicketTypeGroupApiMappings.UPDATE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public TicketTypeGroup update(@RequestBody TicketTypeGroup group, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("update()");
        assertSidObject(ticketTypeGroupService.getBySid(sid));
        assertNotNull(group, "group");
        assertSidIntegrity(group, sid);
        return ticketTypeGroupService.update(group);
    }

    @RequestMapping(value = TicketTypeGroupApiMappings.DELETE, method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("delete()");
        TicketTypeGroup group = ticketTypeGroupService.getBySid(sid);
        assertSidObject(group);
        ticketTypeGroupService.delete(group);
    }
}