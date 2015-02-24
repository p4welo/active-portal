package pl.ap.service.impl;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.dao.*;
import pl.ap.domain.*;
import pl.ap.domain.enums.TicketTypeEnum;
import pl.ap.service.ICustomerService;
import pl.ap.service.ITicketService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-10-16.
 */
@Service
public class CustomerServiceImpl extends IdentifiableServiceImpl<Customer> implements ICustomerService {
    public static final String BEAN_NAME = "customerService";

    @Resource
    private ICustomerDao customerDao;

    @Resource
    private ICustomerPresenceDao customerPresenceDao;

    @Resource
    private ICourseDao courseDao;

    @Resource
    private ITicketService ticketService;

    @Resource
    private ICustomerSubscriptionDao customerSubscriptionDao;

    @Override
    protected IIdentifiableDao<Customer> getDao() {
        return customerDao;
    }

    @Override
    protected String[] getUpdateFields() {
        return new String[]{
                Customer.FIELD_OBJECT_STATE,
                Customer.FIELD_FIRST_NAME,
                Customer.FIELD_LAST_NAME,
                Customer.FIELD_MOBILE,
                Customer.FIELD_MOBILE2,
                Customer.FIELD_EMAIL,
                Customer.FIELD_GENDER
        };
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerPresence> findPresence(Customer customer) {
        return customerPresenceDao.findByCustomer(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findCourses(Customer customer) {
        return customerSubscriptionDao.findCoursesByCustomer(customer);
    }

    @Override
    @Transactional(readOnly = false)
    public void joinCourse(Customer customer, Course course) {
        course = courseDao.getBySid(course.getSid());
        CustomerSubscription subscription = new CustomerSubscription();
        subscription.setCourse(course);
        subscription.setCustomer(customer);

        customerSubscriptionDao.save(subscription);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findCoursesToJoin(Customer customer) {
        return courseDao.findJoinableForCustomer(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findCoursesToRegister(Customer customer) {
        return courseDao.findRegisterableForCustomer(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> findByCourse(Course course) {
        return customerSubscriptionDao.findCustomersByCourse(course);
    }

    @Override
    @Transactional(readOnly = false)
    public List<Customer> findSimilar(Customer customer) {
        return customerDao.findBy(Customer.FIELD_LAST_NAME, customer.getLastName());
    }
}
