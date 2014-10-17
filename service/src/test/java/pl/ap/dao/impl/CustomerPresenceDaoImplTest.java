package pl.ap.dao.impl;

import pl.ap.dao.IAbstractDao;
import pl.ap.dao.ICustomerPresenceDao;
import pl.ap.dao.TestDomainObjectFactory;
import pl.ap.domain.*;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-17.
 */
public class CustomerPresenceDaoImplTest extends AbstractDaoImplTest<CustomerPresence> {
    @Resource
    private ICustomerPresenceDao customerPresenceDao;

    @Override
    protected IAbstractDao<CustomerPresence> getDao() {
        return customerPresenceDao;
    }

    @Override
    protected CustomerPresence getEntity() {
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
        CourseUnit unit = TestDomainObjectFactory.getCourseUnit(course);
        persist(unit);

        Customer customer = TestDomainObjectFactory.getCustomer();
        persist(customer);

        return TestDomainObjectFactory.getCustomerPresence(customer, unit);
    }
}
