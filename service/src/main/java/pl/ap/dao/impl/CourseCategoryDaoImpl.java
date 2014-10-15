package pl.ap.dao.impl;

import org.springframework.stereotype.Repository;
import pl.ap.dao.ICourseCategoryDao;
import pl.ap.domain.CourseCategory;

/**
 * Created by parado on 19.03.14.
 */
@Repository(CourseCategoryDaoImpl.BEAN_NAME)
public class CourseCategoryDaoImpl extends IdentifiableDaoImpl<CourseCategory> implements ICourseCategoryDao {
    public static final String BEAN_NAME = "courseCategoryDao";
}
