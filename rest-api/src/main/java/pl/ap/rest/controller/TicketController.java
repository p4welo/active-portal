package pl.ap.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Customer;
import pl.ap.domain.Ticket;
import pl.ap.rest.api.ApiKeys;
import pl.ap.rest.api.TicketApiMappings;
import pl.ap.service.ITicketService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2015-02-24.
 */
@RestController
public class TicketController {
    private static final Logger LOGGER = Logger.getLogger(TicketController.class);

    @Resource
    private ITicketService ticketService;

    @RequestMapping(value = TicketApiMappings.FIND_ALL, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Ticket> findAll() {
        LOGGER.info("findAll()");
        return ticketService.findAll();
    }

    @RequestMapping(value = TicketApiMappings.CREATE, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Ticket create(@RequestBody Ticket ticket) {
        LOGGER.info("create()");
        Assert.notNull(ticket);
        return ticketService.save(ticket);
    }

    @RequestMapping(value = TicketApiMappings.GET, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Ticket get(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("get()");
        return ticketService.getBySid(sid);
    }

    @RequestMapping(value = TicketApiMappings.ACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Ticket activate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("activate()");
        Ticket ticket = ticketService.getBySid(sid);
        Assert.notNull(ticket);
        return ticketService.activate(ticket);
    }

    @RequestMapping(value = TicketApiMappings.DEACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Ticket deactivate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("deactivate()");
        Ticket ticket = ticketService.getBySid(sid);
        Assert.notNull(ticket);
        return ticketService.deactivate(ticket);
    }

    @RequestMapping(value = TicketApiMappings.UPDATE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Ticket update(@RequestBody Ticket ticket, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("update()");
        Assert.notNull(ticketService.getBySid(sid));
        Assert.notNull(ticket);
        Assert.isTrue(sid.equals(ticket.getSid()));
        return ticketService.update(ticket);
    }

    @RequestMapping(value = TicketApiMappings.DELETE, method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("delete()");
        Ticket ticket = ticketService.getBySid(sid);
        Assert.notNull(ticket);
        ticketService.delete(ticket);
    }

    @RequestMapping(value = TicketApiMappings.FIND_CUSTOMER_BY_CODE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Customer findCustomerByCode(@PathVariable(ApiKeys.CODE) String code) {
        LOGGER.info("findCustomerByCode()");
        Assert.notNull(code);
        return ticketService.findCustomerByCode(code);
    }

    @RequestMapping(value = TicketApiMappings.FIND_BY_CODE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Ticket findByCode(@PathVariable(ApiKeys.CODE) String code) {
        LOGGER.info("findByCode()");
        Assert.notNull(code);
        return ticketService.findByCode(code);
    }
}
