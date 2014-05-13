package co.radomski.setenta.service.impl;

import co.radomski.setenta.dao.IAbstractDao;
import co.radomski.setenta.dao.ICategoryDao;
import co.radomski.setenta.domain.Category;
import co.radomski.setenta.service.ICategoryService;
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
