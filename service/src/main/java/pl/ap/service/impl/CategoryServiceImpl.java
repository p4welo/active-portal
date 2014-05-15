package pl.ap.service.impl;

import pl.ap.dao.IAbstractDao;
import pl.ap.dao.ICategoryDao;
import pl.ap.domain.Category;
import pl.ap.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by parado on 19.03.14.
 */
@Service(CategoryServiceImpl.BEAN_NAME)
public class CategoryServiceImpl extends AbstractServiceImpl<Category> implements ICategoryService
{
   public static final String BEAN_NAME = "categoryService";

   @Resource
   private ICategoryDao categoryDao;

   @Override
   protected IAbstractDao<Category> getDao()
   {
      return categoryDao;
   }
}
