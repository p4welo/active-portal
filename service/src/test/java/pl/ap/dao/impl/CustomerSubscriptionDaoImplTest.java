package pl.ap.dao.impl;

import pl.ap.dao.IAbstractDao;
import pl.ap.dao.ICustomerSubscriptionDao;
import pl.ap.dao.TestDomainObjectFactory;
import pl.ap.domain.*;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-17.
 */
public class CustomerSubscriptionDaoImplTest extends AbstractDaoImplTest<CustomerSubscription> {
    @Resource
    private ICustomerSubscriptionDao customerSubscriptionDao;

    @Override
    protected IAbstractDao<CustomerSubscription> getDao() {
        return customerSubscriptionDao;
    }

    @Override
    protected CustomerSubscription getEntity() {
        Customer customer = TestDomainObjectFactory.getCustomer();
        persist(customer);
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

        return TestDomainObjectFactory.getCustomerSubscription(customer, course);
    }
}
