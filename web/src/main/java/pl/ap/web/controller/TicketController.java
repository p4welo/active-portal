package pl.ap.web.controller;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Customer;
import pl.ap.domain.Ticket;
import pl.ap.web.api.ApiKeys;
import pl.ap.web.api.CommonApiMappings;
import pl.ap.web.api.TicketApiMappings;
import pl.ap.service.ITicketService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2015-02-24.
 */
@RestController
@RequestMapping(value = CommonApiMappings.REST_PREFIX)
public class TicketController extends AbstractController {
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
        assertNotNull(ticket, "ticket");
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
        assertSidObject(ticket);
        return ticketService.activate(ticket);
    }

    @RequestMapping(value = TicketApiMappings.DEACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Ticket deactivate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("deactivate()");
        Ticket ticket = ticketService.getBySid(sid);
        assertSidObject(ticket);
        return ticketService.deactivate(ticket);
    }

    public static void main(String[] args) {
        DateTime time = new DateTime();
        System.out.println(time.toString("yyyy-MM-dd hh:mm"));
    }

    @RequestMapping(value = TicketApiMappings.UPDATE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Ticket update(@RequestBody Ticket ticket, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("update()");
        assertSidObject(ticketService.getBySid(sid));
        assertSidObject(ticket);
        assertSidIntegrity(ticket, sid);
        return ticketService.update(ticket);
    }

    @RequestMapping(value = TicketApiMappings.DELETE, method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("delete()");
        Ticket ticket = ticketService.getBySid(sid);
        assertSidObject(ticket);
        ticketService.delete(ticket);
    }

    @RequestMapping(value = TicketApiMappings.FIND_CUSTOMER_BY_CODE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Customer findCustomerByCode(@PathVariable(ApiKeys.CODE) String code) {
        LOGGER.info("findCustomerByCode()");
        assertNotNull(code, "code");
        return ticketService.findCustomerByCode(code);
    }

    @RequestMapping(value = TicketApiMappings.FIND_BY_CODE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Ticket findByCode(@PathVariable(ApiKeys.CODE) String code) {
        LOGGER.info("findByCode()");
        assertNotNull(code, "code");
        return ticketService.findByCode(code);
    }
}
