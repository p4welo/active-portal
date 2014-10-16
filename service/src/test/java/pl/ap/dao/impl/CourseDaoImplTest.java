package pl.ap.dao.impl;

import pl.ap.dao.ICourseDao;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.TestDomainObjectFactory;
import pl.ap.domain.*;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-16.
 */
public class CourseDaoImplTest extends IdentifiableDaoImplTest<Course> {
    @Resource
    private ICourseDao courseDao;

    @Override
    protected IIdentifiableDao<Course> getDao() {
        return courseDao;
    }

    @Override
    protected Course getEntity() {
        CourseCategory category = TestDomainObjectFactory.getCourseCategory();
        persist(category);
        CourseStyle style = TestDomainObjectFactory.getCourseStyle(category);
        persist(style);
        Instructor instructor = TestDomainObjectFactory.getInstructor();
        persist(instructor);
        Room room = TestDomainObjectFactory.getRoom();
        persist(room);

        return TestDomainObjectFactory.getCourse(style, instructor, room);
    }
}
