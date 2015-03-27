package pl.ap.dao.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.ICustomerPresenceDao;
import pl.ap.factory.TestDomainObjectFactory;
import pl.ap.domain.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-10-17.
 */
public class CustomerPresenceDaoImplTest extends AbstractDaoImplTest<CustomerPresence> {
    @Resource
    private ICustomerPresenceDao customerPresenceDao;

    private Customer customer;
    private CourseLesson unit;

    @Override
    protected IAbstractDao<CustomerPresence> getDao() {
        return customerPresenceDao;
    }

    @Before
    public void setup() {
        CourseCategory category = TestDomainObjectFactory.getCourseCategory();
        persist(category);
        CourseStyle style = TestDomainObjectFactory.getCourseStyle(category);
        persist(style);
        Instructor instructor = TestDomainObjectFactory.getInstructor();
        persist(instructor);
        Room room = TestDomainObjectFactory.getRoom();
        persist(room);
        Course course = TestDomainObjectFactory.getCourse(style, instructor, room);
        persist(course);
        unit = TestDomainObjectFactory.getCourseUnit(course);
        persist(unit);

        customer = TestDomainObjectFactory.getCustomer();
        persist(customer);
    }

    @Override
    protected CustomerPresence getEntity() {
        return TestDomainObjectFactory.getCustomerPresence(customer, unit);
    }

    @Test
    public void testFindByCustomer() {
        persist(TestDomainObjectFactory.getCustomerPresence(customer, unit));

        List<CustomerPresence> result = customerPresenceDao.findByCustomer(customer);

        Assert.assertNotNull(result);
        Assert.assertTrue(result.size() == 1);
    }
}
