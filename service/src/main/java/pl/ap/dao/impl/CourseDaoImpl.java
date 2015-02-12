package pl.ap.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.*;
import org.springframework.stereotype.Repository;
import pl.ap.dao.ICourseDao;
import pl.ap.domain.*;
import pl.ap.domain.enums.ObjectStateEnum;

import java.util.List;

/**
 * Created by parado on 19.03.14.
 */
@Repository(CourseDaoImpl.BEAN_NAME)
public class CourseDaoImpl extends IdentifiableDaoImpl<Course> implements ICourseDao {
    public static final String BEAN_NAME = "courseDao";

    @Override
    public List<Course> findAll() {
        Criteria criteria = createCriteria()
                .addOrder(Order.asc(Course.FIELD_DAY))
                .addOrder(Order.asc(Course.FIELD_START_TIME));
        return criteria.list();
    }

    @Override
    public List<Course> findForSchedule() {
        Criteria criteria = createCriteria()
                .add(Restrictions.eq(Course.FIELD_OBJECT_STATE, ObjectStateEnum.ACTIVE))
                .add(Restrictions.eq(Course.FIELD_IN_PROGRESS, Boolean.TRUE))
                .addOrder(Order.asc(Course.FIELD_DAY))
                .addOrder(Order.asc(Course.FIELD_START_TIME));
        return criteria.list();
    }

    @Override
    public List<Course> findInProgress() {
        Criteria criteria = createCriteria()
                .add(Restrictions.eq(Course.FIELD_IN_PROGRESS, true))
                .addOrder(Order.asc(Course.FIELD_DAY))
                .addOrder(Order.asc(Course.FIELD_START_TIME));
        return criteria.list();
    }

    @Override
    public List<Course> findRegistration() {
        Criteria criteria = createCriteria()
                .add(Restrictions.eq(Course.FIELD_CAN_REGISTER, true))
                .addOrder(Order.asc(Course.FIELD_DAY))
                .addOrder(Order.asc(Course.FIELD_START_TIME));
        return criteria.list();
    }

    @Override
    public List<Course> findActiveByInstructor(Instructor instructor) {
        Criteria criteria = createCriteria()
                .add(Restrictions.eq(Course.FIELD_INSTRUCTOR, instructor))
                .add(Restrictions.eq(Course.FIELD_OBJECT_STATE, ObjectStateEnum.ACTIVE))
                .addOrder(Order.asc(Course.FIELD_DAY))
                .addOrder(Order.asc(Course.FIELD_START_TIME));
        return criteria.list();
    }

    @Override
    public List<Course> findJoinableForCustomer(Customer customer) {
        Criteria criteria = createCriteria()
                .add(Restrictions.eq(Course.FIELD_OBJECT_STATE, ObjectStateEnum.ACTIVE))
                .add(Restrictions.eq(Course.FIELD_IN_PROGRESS, true))
                .add(Restrictions.eq(Course.FIELD_CAN_JOIN, true))
                .addOrder(Order.asc(Course.FIELD_START_TIME));

        DetachedCriteria customersCourses = DetachedCriteria.forClass(CustomerSubscription.class)
                .add(Restrictions.eq(CustomerSubscription.FIELD_CUSTOMER, customer))
                .createAlias(CustomerSubscription.FIELD_COURSE, CustomerSubscription.FIELD_COURSE)
                .setProjection(Property.forName(CustomerSubscription.FIELD_COURSE + "." + Course.FIELD_ID));
        criteria.add(Subqueries.propertyNotIn(Course.FIELD_ID, customersCourses));

        return criteria.list();
    }

    @Override
    public List<Course> findRegisterableForCustomer(Customer customer) {
        Criteria criteria = createCriteria()
                .add(Restrictions.eq(Course.FIELD_OBJECT_STATE, ObjectStateEnum.ACTIVE))
                .add(Restrictions.eq(Course.FIELD_CAN_REGISTER, true))
                .addOrder(Order.asc(Course.FIELD_START_TIME));

        DetachedCriteria customersCourses = DetachedCriteria.forClass(CustomerSubscription.class)
                .add(Restrictions.eq(CustomerSubscription.FIELD_CUSTOMER, customer))
                .createAlias(CustomerSubscription.FIELD_COURSE, CustomerSubscription.FIELD_COURSE)
                .setProjection(Property.forName(CustomerSubscription.FIELD_COURSE + "." + Course.FIELD_ID));
        criteria.add(Subqueries.propertyNotIn(Course.FIELD_ID, customersCourses));

        return criteria.list();
    }

    @Override
    public List<Course> findActiveByStyle(CourseStyle style) {
        Criteria criteria = createCriteria()
                .add(Restrictions.eq(Course.FIELD_OBJECT_STATE, ObjectStateEnum.ACTIVE))
                .add(Restrictions.eq(Course.FIELD_STYLE, style))
                .addOrder(Order.asc(Course.FIELD_DAY))
                .addOrder(Order.asc(Course.FIELD_START_TIME));
        return criteria.list();
    }
}
