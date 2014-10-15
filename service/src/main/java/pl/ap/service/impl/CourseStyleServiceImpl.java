package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.ICourseStyleDao;
import pl.ap.domain.CourseCategory;
import pl.ap.domain.CourseStyle;
import pl.ap.service.ICourseCategoryService;
import pl.ap.service.ICourseStyleService;

import javax.annotation.Resource;

/**
 * Created by parado on 19.03.14.
 */
@Service(CourseStyleServiceImpl.BEAN_NAME)
public class CourseStyleServiceImpl extends AbstractServiceImpl<CourseStyle> implements ICourseStyleService {
    public static final String BEAN_NAME = "courseStyleService";

    @Resource
    private ICourseStyleDao styleDao;

    @Resource
    private ICourseCategoryService categoryService;

    @Override
    protected IAbstractDao<CourseStyle> getDao() {
        return styleDao;
    }

    @Override
    @Transactional(readOnly = false)
    public CourseStyle save(CourseStyle courseStyle) {
        CourseCategory courseCategory = categoryService.getBySid(courseStyle.getCategory().getSid());
        courseStyle.setCategory(courseCategory);
        return super.save(courseStyle);
    }
}
