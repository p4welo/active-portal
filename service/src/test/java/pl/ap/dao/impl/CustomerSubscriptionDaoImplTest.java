package pl.ap.dao.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.ICustomerSubscriptionDao;
import pl.ap.factory.TestDomainObjectFactory;
import pl.ap.domain.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-10-17.
 */
public class CustomerSubscriptionDaoImplTest extends AbstractDaoImplTest<CustomerSubscription> {
    @Resource
    private ICustomerSubscriptionDao customerSubscriptionDao;

    private Customer customer;
    private Course course;

    @Override
    protected IAbstractDao<CustomerSubscription> getDao() {
        return customerSubscriptionDao;
    }

    @Before
    public void setup() {
        customer = TestDomainObjectFactory.getCustomer();
        persist(customer);
        CourseCategory category = TestDomainObjectFactory.getCourseCategory();
        persist(category);
        CourseStyle style = TestDomainObjectFactory.getCourseStyle(category);
        persist(style);
        Instructor instructor = TestDomainObjectFactory.getInstructor();
        persist(instructor);
        Room room = TestDomainObjectFactory.getRoom();
        persist(room);
        course = TestDomainObjectFactory.getCourse(style, instructor, room);
        persist(course);
    }

    @Override
    protected CustomerSubscription getEntity() {
        return TestDomainObjectFactory.getCustomerSubscription(customer, course);
    }

    @Test
    public void testFindCoursesByCustomer() {
        persist(TestDomainObjectFactory.getCustomerSubscription(customer, course));

        List<Course> result = customerSubscriptionDao.findCoursesByCustomer(customer);

        Assert.assertNotNull(result);
        Assert.assertTrue(result.size() == 1);
    }
}
