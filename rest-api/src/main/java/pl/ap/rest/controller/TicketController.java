package pl.ap.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Customer;
import pl.ap.rest.api.ApiKeys;
import pl.ap.rest.api.TicketApiMappings;
import pl.ap.service.ITicketService;

import javax.annotation.Resource;

/**
 * Created by parado on 2015-02-24.
 */
@RestController
public class TicketController {
    private static final Logger LOGGER = Logger.getLogger(TicketController.class);

    @Resource
    private ITicketService ticketService;

    @RequestMapping(value = TicketApiMappings.FIND_CUSTOMER_BY_CODE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Customer findCustomerByCode(@PathVariable(ApiKeys.CODE) String code) {
        LOGGER.info("findCustomerByCode()");

        Assert.notNull(code);
        return ticketService.findCustomerByCode(code);
    }
}
