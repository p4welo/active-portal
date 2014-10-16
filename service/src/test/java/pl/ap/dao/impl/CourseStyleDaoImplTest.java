package pl.ap.dao.impl;

import pl.ap.dao.ICourseStyleDao;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.TestDomainObjectFactory;
import pl.ap.domain.CourseCategory;
import pl.ap.domain.CourseStyle;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-16.
 */
public class CourseStyleDaoImplTest extends IdentifiableDaoImplTest<CourseStyle> {
    @Resource
    private ICourseStyleDao courseStyleDao;

    @Override
    protected IIdentifiableDao<CourseStyle> getDao() {
        return courseStyleDao;
    }

    @Override
    protected CourseStyle getEntity() {
        CourseCategory category = TestDomainObjectFactory.getCourseCategory();
        persist(category);
        return TestDomainObjectFactory.getCourseStyle(category);
    }
}
