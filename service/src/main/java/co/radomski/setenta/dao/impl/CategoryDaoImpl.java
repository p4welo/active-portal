package co.radomski.setenta.dao.impl;

import co.radomski.setenta.dao.ICategoryDao;
import co.radomski.setenta.domain.Category;
import org.springframework.stereotype.Repository;

/**
 * Created by parado on 19.03.14.
 */
@Repository(CategoryDaoImpl.BEAN_NAME)
public class CategoryDaoImpl extends AbstractDaoImpl<Category> implements ICategoryDao
{
   public static final String BEAN_NAME = "categoryDao";
}
