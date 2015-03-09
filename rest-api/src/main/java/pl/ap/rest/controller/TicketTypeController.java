package pl.ap.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.TicketType;
import pl.ap.rest.api.ApiKeys;
import pl.ap.rest.api.TicketTypeApiMappings;
import pl.ap.service.ITicketTypeService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2015-03-05.
 */
@RestController
public class TicketTypeController {
    private static final Logger LOGGER = Logger.getLogger(TicketTypeController.class);

    @Resource
    private ITicketTypeService ticketTypeService;


    @RequestMapping(value = TicketTypeApiMappings.FIND_ALL, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TicketType> findAll() {
        LOGGER.info("findAll()");
        return ticketTypeService.findAll();
    }

    @RequestMapping(value = TicketTypeApiMappings.CREATE, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public TicketType create(@RequestBody TicketType type) {
        LOGGER.info("create()");

        Assert.notNull(type);
        Assert.notNull(type.getGroup());

        return ticketTypeService.save(type);
    }

    @RequestMapping(value = TicketTypeApiMappings.GET, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TicketType get(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("get()");
        return ticketTypeService.getBySid(sid);
    }

    @RequestMapping(value = TicketTypeApiMappings.ACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TicketType activate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("activate()");

        TicketType type = ticketTypeService.getBySid(sid);
        Assert.notNull(type);

        return ticketTypeService.activate(type);
    }

    @RequestMapping(value = TicketTypeApiMappings.DEACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TicketType deactivate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("deactivate()");

        TicketType type = ticketTypeService.getBySid(sid);
        Assert.notNull(type);

        return ticketTypeService.deactivate(type);
    }

    @RequestMapping(value = TicketTypeApiMappings.UPDATE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public TicketType update(@RequestBody TicketType type, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("update()");

        Assert.notNull(ticketTypeService.getBySid(sid));
        Assert.notNull(type);
        Assert.isTrue(sid.equals(type.getSid()));

        return ticketTypeService.update(type);
    }

    @RequestMapping(value = TicketTypeApiMappings.DELETE, method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("delete()");

        TicketType type = ticketTypeService.getBySid(sid);
        Assert.notNull(type);

        ticketTypeService.delete(type);
    }
}
