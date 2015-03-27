package pl.ap.dao.impl;

import pl.ap.dao.IAbstractDao;
import pl.ap.dao.ICourseLessonDao;
import pl.ap.factory.TestDomainObjectFactory;
import pl.ap.domain.*;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-17.
 */
public class CourseLessonDaoImplTest extends AbstractDaoImplTest<CourseLesson> {
    @Resource
    private ICourseLessonDao courseUnitDao;

    @Override
    protected IAbstractDao<CourseLesson> getDao() {
        return courseUnitDao;
    }

    @Override
    protected CourseLesson getEntity() {
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
