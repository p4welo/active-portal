package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.ICourseCategoryDao;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.domain.CourseCategory;
import pl.ap.domain.enums.ObjectStateEnum;
import pl.ap.service.ICourseCategoryService;

import javax.annotation.Resource;

/**
 * Created by parado on 19.03.14.
 */
@Service(CourseCategoryServiceImpl.BEAN_NAME)
public class CourseCategoryServiceImpl extends IdentifiableServiceImpl<CourseCategory> implements ICourseCategoryService {

    public static final String BEAN_NAME = "courseCategoryService";

    @Resource
    private ICourseCategoryDao courseCategoryDao;

    @Override
    protected IIdentifiableDao<CourseCategory> getDao() {
        return courseCategoryDao;
    }

    @Override
    @Transactional(readOnly = false)
    public CourseCategory update(CourseCategory c) {
        CourseCategory category = getBySid(c.getSid());
        category.setCode(c.getCode());
        category.setName(c.getName());
        return super.update(category);
    }

    @Override
    protected String[] getUpdateFields() {
        return new String[] {
                CourseCategory.FIELD_OBJECT_STATE,
                CourseCategory.FIELD_CODE,
                CourseCategory.FIELD_NAME
        };
    }
}
