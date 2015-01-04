package pl.ap.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import pl.ap.dao.ICustomerPresenceDao;
import pl.ap.dao.dto.CoursePresenceDaoDto;
import pl.ap.domain.Course;
import pl.ap.domain.Customer;
import pl.ap.domain.CustomerPresence;
import pl.ap.domain.CustomerSubscription;

import java.util.List;

/**
 * Created by parado on 2014-10-17.
 */
@Repository(CustomerPresenceDaoImpl.BEAN_NAME)
public class CustomerPresenceDaoImpl extends AbstractDaoImpl<CustomerPresence> implements ICustomerPresenceDao {
    public static final String BEAN_NAME = "customerPresence";

    @Override
    public List<CustomerPresence> findByCustomer(Customer customer) {
        Criteria criteria = createCriteria()
                .add(Restrictions.eq(CustomerPresence.FIELD_CUSTOMER, customer));
        return criteria.list();
    }

//    @Override
//    public List<CustomerPresence> findByLessons(List<CourseUnit> lessons) {
//        Criteria criteria = createCriteria()
//                .add(Restrictions.in(CustomerPresence.FIELD_LESSON, lessons));
//        return criteria.list();
//    }

    @Override
    public List<CoursePresenceDaoDto> findByCourse(Course course) {

        Session session = getSessionFactory().getCurrentSession();
        List result = session.createSQLQuery(
                "SELECT s.customer_id as customer, " +
                        "l.date_time as lesson, " +
                        "p.present as present " +
                        "FROM customer_subscription as s " +
                        "LEFT JOIN course_unit as l on s.course_id=l.course_id " +
                        "LEFT JOIN customer_presence as p on s.customer_id=p.customer_id AND l.id=p.lesson_id " +
                        "WHERE s.course_id=1 " +
                        "ORDER BY customer, lesson")
                .addScalar("customer")
                .addScalar("lesson")
                .addScalar("present")
                .setResultTransformer(Transformers.aliasToBean(CoursePresenceDaoDto.class))
                .list();
        return result;
    }

}
