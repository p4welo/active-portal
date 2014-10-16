package pl.ap.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Customer;
import pl.ap.rest.api.ApiKeys;
import pl.ap.rest.api.CustomerApiMappings;
import pl.ap.service.ICustomerService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-10-15.
 */
@RestController
public class CustomerController {
    private static final Logger LOGGER = Logger.getLogger(CustomerController.class);

    @Resource
    private ICustomerService customerService;

    @RequestMapping(value = CustomerApiMappings.FIND_ALL, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Customer> findAll() {
        LOGGER.info("findAll()");
        return customerService.findAll();
    }

    @RequestMapping(value = CustomerApiMappings.CREATE, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Customer create(@RequestBody Customer category) {
        LOGGER.info("create()");

        Assert.notNull(category);

        return customerService.save(category);
    }

    @RequestMapping(value = CustomerApiMappings.GET, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Customer get(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("get()");
        return customerService.getBySid(sid);
    }

//    @RequestMapping(value = CustomerApiMappings.ACTIVATE, method = RequestMethod.PUT)
//    @ResponseStatus(value = HttpStatus.OK)
//    public Customer activate(@PathVariable(ApiKeys.SID) String sid) {
//        LOGGER.info("activate()");
//
//        Customer customer = customerService.getBySid(sid);
//        Assert.notNull(customer);
//
//        return customerService.activate(customer);
//    }
//
//    @RequestMapping(value = CustomerApiMappings.DEACTIVATE, method = RequestMethod.PUT)
//    @ResponseStatus(value = HttpStatus.OK)
//    public Customer deactivate(@PathVariable(ApiKeys.SID) String sid) {
//        LOGGER.info("deactivate()");
//
//        Customer customer = customerService.getBySid(sid);
//        Assert.notNull(customer);
//
//        return customerService.deactivate(customer);
//    }

    @RequestMapping(value = CustomerApiMappings.UPDATE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Customer update(@RequestBody Customer category, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("update()");

        Assert.notNull(customerService.getBySid(sid));
        Assert.notNull(category);
        Assert.isTrue(sid.equals(category.getSid()));

        return customerService.update(category);
    }

    @RequestMapping(value = CustomerApiMappings.DELETE, method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("delete()");

        Customer customer = customerService.getBySid(sid);
        Assert.notNull(customer);

        customerService.delete(customer);
    }
}