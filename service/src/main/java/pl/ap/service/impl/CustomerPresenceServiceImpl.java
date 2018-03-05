package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.ICourseLessonDao;
import pl.ap.dao.ICustomerPresenceDao;
import pl.ap.dao.ICustomerSubscriptionDao;
import pl.ap.domain.Course;
import pl.ap.domain.Customer;
import pl.ap.domain.CustomerPresence;
import pl.ap.service.ICustomerPresenceService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by parado on 2014-10-17.
 */
@Service(CustomerPresenceServiceImpl.BEAN_NAME)
public class CustomerPresenceServiceImpl extends AbstractServiceImpl<CustomerPresence> implements ICustomerPresenceService {
    public static final String BEAN_NAME = "customerPresenceService";

    @Resource
    private ICustomerPresenceDao customerPresenceDao;

    @Resource
    private ICustomerSubscriptionDao customerSubscriptionDao;

    @Resource
    private ICourseLessonDao courseLessonDao;

    @Override
    protected IAbstractDao<CustomerPresence> getDao() {
        return customerPresenceDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Map<Customer, List<CustomerPresence>> findLastByCourse(Course course, int maxResults) {

//        List<CoursePresenceDaoDto> dtos = customerPresenceDao.findByCourse(course);
        return null;
    }
}
