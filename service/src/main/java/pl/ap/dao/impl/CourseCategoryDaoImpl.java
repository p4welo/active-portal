package pl.ap.dao.impl;

import pl.ap.dao.ICourseCategoryDao;
import pl.ap.domain.CourseCategory;
import org.springframework.stereotype.Repository;

/**
 * Created by parado on 19.03.14.
 */
@Repository(CourseCategoryDaoImpl.BEAN_NAME)
public class CourseCategoryDaoImpl extends AbstractDaoImpl<CourseCategory> implements ICourseCategoryDao
{
   public static final String BEAN_NAME = "courseCategoryDao";
}
