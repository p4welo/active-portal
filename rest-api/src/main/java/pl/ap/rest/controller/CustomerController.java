package pl.ap.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Course;
import pl.ap.domain.Customer;
import pl.ap.domain.CustomerPresence;
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
    public Customer create(@RequestBody Customer customer) {
        LOGGER.info("create()");

        Assert.notNull(customer);

        return customerService.save(customer);
    }

    @RequestMapping(value = CustomerApiMappings.GET, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Customer get(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("get()");
        return customerService.getBySid(sid);
    }

    @RequestMapping(value = CustomerApiMappings.UPDATE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Customer update(@RequestBody Customer customer, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("update()");

        Assert.notNull(customerService.getBySid(sid));
        Assert.notNull(customer);
        Assert.isTrue(sid.equals(customer.getSid()));

        return customerService.update(customer);
    }

    @RequestMapping(value = CustomerApiMappings.DELETE, method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("delete()");

        Customer customer = customerService.getBySid(sid);
        Assert.notNull(customer);

        customerService.delete(customer);
    }

    @RequestMapping(value = CustomerApiMappings.PRESENCE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<CustomerPresence> presence(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("presence()");

        Customer customer = customerService.getBySid(sid);
        Assert.notNull(customer);

        return customerService.findPresence(customer);
    }

    @RequestMapping(value = CustomerApiMappings.COURSES, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Course> courses(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("courses()");

        Customer customer = customerService.getBySid(sid);
        Assert.notNull(customer);

        return customerService.findCourses(customer);
    }

    @RequestMapping(value = CustomerApiMappings.COURSES_TO_JOIN, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Course> coursesToJoin(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("coursesToJoin()");

        Customer customer = customerService.getBySid(sid);
        Assert.notNull(customer);

        return customerService.findCoursesToJoin(customer);
    }

    @RequestMapping(value = CustomerApiMappings.COURSES_TO_REGISTER, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Course> coursesToRegister(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("coursesToRegister()");

        Customer customer = customerService.getBySid(sid);
        Assert.notNull(customer);

        return customerService.findCoursesToRegister(customer);
    }

    @RequestMapping(value = CustomerApiMappings.JOIN, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void joinCourse(@PathVariable(ApiKeys.SID) String sid, @RequestBody Course course) {
        LOGGER.info("joinCourse()");

        Customer customer = customerService.getBySid(sid);
        Assert.notNull(customer);
        Assert.notNull(course);

        customerService.joinCourse(customer, course);
    }

    @RequestMapping(value = CustomerApiMappings.SUBSCRIBE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void subscribeCourse(@PathVariable(ApiKeys.SID) String sid, @RequestBody Course course) {
        LOGGER.info("subscribeCourse()");

        Customer customer = customerService.getBySid(sid);
        Assert.notNull(customer);
        Assert.notNull(course);

        customerService.joinCourse(customer, course);
    }
}