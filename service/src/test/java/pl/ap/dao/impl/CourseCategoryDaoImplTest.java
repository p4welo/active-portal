package pl.ap.dao.impl;

import pl.ap.dao.ICourseCategoryDao;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.TestDomainObjectFactory;
import pl.ap.domain.CourseCategory;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-16.
 */
public class CourseCategoryDaoImplTest extends IdentifiableDaoImplTest<CourseCategory> {
    @Resource
    private ICourseCategoryDao courseCategoryDao;

    @Override
    protected IIdentifiableDao<CourseCategory> getDao() {
        return courseCategoryDao;
    }

    @Override
    protected CourseCategory getEntity() {
        return TestDomainObjectFactory.getCourseCategory();
    }
}
