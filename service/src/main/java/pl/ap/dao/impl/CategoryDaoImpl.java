package pl.ap.dao.impl;

import pl.ap.dao.ICategoryDao;
import pl.ap.domain.Category;
import org.springframework.stereotype.Repository;

/**
 * Created by parado on 19.03.14.
 */
@Repository(CategoryDaoImpl.BEAN_NAME)
public class CategoryDaoImpl extends AbstractDaoImpl<Category> implements ICategoryDao
{
   public static final String BEAN_NAME = "categoryDao";
}
