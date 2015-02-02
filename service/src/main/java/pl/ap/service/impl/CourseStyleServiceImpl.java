package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.ICourseDao;
import pl.ap.dao.ICourseStyleDao;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.domain.Course;
import pl.ap.domain.CourseCategory;
import pl.ap.domain.CourseStyle;
import pl.ap.service.ICourseCategoryService;
import pl.ap.service.ICourseStyleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 19.03.14.
 */
@Service(CourseStyleServiceImpl.BEAN_NAME)
public class CourseStyleServiceImpl extends IdentifiableServiceImpl<CourseStyle> implements ICourseStyleService {
    public static final String BEAN_NAME = "courseStyleService";

    @Resource
    private ICourseStyleDao styleDao;

    @Resource
    private ICourseDao courseDao;

    @Resource
    private ICourseCategoryService categoryService;

    @Override
    protected IIdentifiableDao<CourseStyle> getDao() {
        return styleDao;
    }

    @Override
    @Transactional(readOnly = false)
    public CourseStyle save(CourseStyle courseStyle) {
        CourseCategory courseCategory = categoryService.getBySid(courseStyle.getCategory().getSid());
        courseStyle.setCategory(courseCategory);
        return super.save(courseStyle);
    }

    @Override
    protected String[] getUpdateFields() {
        return new String[] {
                CourseStyle.FIELD_OBJECT_STATE,
                CourseStyle.FIELD_NAME,
                CourseStyle.FIELD_CATEGORY
        };
    }

    @Override
    @Transactional(readOnly = false)
    public CourseStyle setCategory(CourseStyle style, CourseCategory category) {
        category = categoryService.getBySid(category.getSid());
        style.setCategory(category);
        return super.update(style);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findActiveByStyle(CourseStyle style) {
        return courseDao.findActiveByStyle(style);
    }
}
