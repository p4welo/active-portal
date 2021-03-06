package pl.ap.web.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.*;
import pl.ap.service.ICustomerService;
import pl.ap.service.ITicketService;
import pl.ap.service.ITicketTypeService;
import pl.ap.web.api.ApiKeys;
import pl.ap.web.api.CommonApiMappings;
import pl.ap.web.api.CustomerApiMappings;
import pl.ap.web.dto.CustomerDto;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-10-15.
 */
@RestController
@RequestMapping(value = CommonApiMappings.REST_PREFIX)
public class CustomerController extends AbstractController {
    private static final Logger LOGGER = Logger.getLogger(CustomerController.class);

    @Resource
    private ICustomerService customerService;

    @Resource
    private ITicketService ticketService;

    @Resource
    private ITicketTypeService ticketTypeService;

    @RequestMapping(value = CustomerApiMappings.FIND_ALL, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Customer> findAll() {
        LOGGER.info("findAll()");
        return customerService.findAll();
    }

    @RequestMapping(value = CustomerApiMappings.CREATE, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Customer create(@RequestBody CustomerDto dto) {
        LOGGER.info("create()");

        assertNotNull(dto, "dto");
        assertNotNull(dto.getCustomer(), "customer");
        assertNotNull(dto.getCourses(), "courses");

        Customer customer = customerService.save(dto.getCustomer());
        for (Course course : dto.getCourses()) {
            customerService.joinCourse(customer, course);
        }
        return customer;
    }

    @RequestMapping(value = CustomerApiMappings.GET, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Customer get(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("get()");
        Customer customer = customerService.getBySid(sid);
        assertSidObject(customer);
        return customer;
    }

    @RequestMapping(value = CustomerApiMappings.UPDATE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Customer update(@RequestBody Customer customer, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("update()");

        assertSidObject(customerService.getBySid(sid));
        assertNotNull(customer, "customer");
        assertSidIntegrity(customer, sid);

        return customerService.update(customer);
    }

    @RequestMapping(value = CustomerApiMappings.DELETE, method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("delete()");
        Customer customer = customerService.getBySid(sid);
        assertSidObject(customer);
        customerService.delete(customer);
    }

    @RequestMapping(value = CustomerApiMappings.PRESENCE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<CustomerPresence> presence(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("presence()");
        Customer customer = customerService.getBySid(sid);
        assertSidObject(customer);
        return customerService.findPresence(customer);
    }

    @RequestMapping(value = CustomerApiMappings.COURSES, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Course> courses(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("courses()");
        Customer customer = customerService.getBySid(sid);
        assertSidObject(customer);
        return customerService.findCourses(customer);
    }

    @RequestMapping(value = CustomerApiMappings.COURSES_TO_JOIN, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Course> coursesToJoin(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("coursesToJoin()");
        Customer customer = customerService.getBySid(sid);
        assertSidObject(customer);
        return customerService.findCoursesToJoin(customer);
    }

    @RequestMapping(value = CustomerApiMappings.COURSES_TO_REGISTER, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Course> coursesToRegister(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("coursesToRegister()");
        Customer customer = customerService.getBySid(sid);
        assertSidObject(customer);
        return customerService.findCoursesToRegister(customer);
    }

    @RequestMapping(value = CustomerApiMappings.JOIN, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void joinCourse(@PathVariable(ApiKeys.SID) String sid, @RequestBody Course course) {
        LOGGER.info("joinCourse()");
        Customer customer = customerService.getBySid(sid);
        assertSidObject(customer);
        assertNotNull(course, "course");
        customerService.joinCourse(customer, course);
    }

    @RequestMapping(value = CustomerApiMappings.SUBSCRIBE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void subscribeCourse(@PathVariable(ApiKeys.SID) String sid, @RequestBody Course course) {
        LOGGER.info("subscribeCourse()");
        Customer customer = customerService.getBySid(sid);
        assertSidObject(customer);
        assertNotNull(course, "course");
        customerService.joinCourse(customer, course);
    }

    @RequestMapping(value = CustomerApiMappings.FIND_SIMILAR, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Customer> findSimilar(@RequestBody Customer customer) {
        LOGGER.info("findSimilar()");
        assertNotNull(customer, "customer");
        return customerService.findSimilar(customer);
    }

    @RequestMapping(value = CustomerApiMappings.BUY_TICKET, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Customer buyTicket(@PathVariable(ApiKeys.SID) String sid, @RequestBody Ticket ticket) {
        LOGGER.info("buyTicket()");

        Customer customer = customerService.getBySid(sid);
        assertSidObject(customer);
        assertNotNull(ticket, "ticket");
        assertNotNull(ticket.getType(), "type");
        TicketType type = ticketTypeService.getBySid(ticket.getType().getSid());
        assertSidObject(type);
        ticket.setType(type);
        ticketService.buy(customer, ticket);
        return customer;
    }
}