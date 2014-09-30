package pl.ap.service.impl;

import pl.ap.dao.IAbstractDao;
import pl.ap.dao.ICourseCategoryDao;
import pl.ap.domain.CourseCategory;
import pl.ap.service.ICourseCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by parado on 19.03.14.
 */
@Service(CourseCategoryServiceImpl.BEAN_NAME)
public class CourseCategoryServiceImpl extends AbstractServiceImpl<CourseCategory> implements ICourseCategoryService
{
   public static final String BEAN_NAME = "courseCategoryService";

   @Resource
   private ICourseCategoryDao courseCategoryDao;

   @Override
   protected IAbstractDao<CourseCategory> getDao()
   {
      return courseCategoryDao;
   }
}
