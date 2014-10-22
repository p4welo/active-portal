package pl.ap.dao.impl;

import pl.ap.dao.IAbstractDao;
import pl.ap.dao.ICourseUnitDao;
import pl.ap.dao.TestDomainObjectFactory;
import pl.ap.domain.*;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-17.
 */
public class CourseUnitDaoImplTest extends AbstractDaoImplTest<CourseUnit> {
    @Resource
    private ICourseUnitDao courseUnitDao;

    @Override
    protected IAbstractDao<CourseUnit> getDao() {
        return courseUnitDao;
    }

    @Override
    protected CourseUnit getEntity() {
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

        return TestDomainObjectFactory.getCourseUnit(course);
    }
}
