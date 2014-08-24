package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IStyleDao;
import pl.ap.domain.Category;
import pl.ap.domain.Style;
import pl.ap.service.ICategoryService;
import pl.ap.service.IStyleService;

import javax.annotation.Resource;

/**
 * Created by parado on 19.03.14.
 */
@Service(StyleServiceImpl.BEAN_NAME)
public class StyleServiceImpl extends AbstractServiceImpl<Style> implements IStyleService
{
   public static final String BEAN_NAME = "styleService";

   @Resource
   private IStyleDao styleDao;

   @Resource
   private ICategoryService categoryService;

   @Override
   protected IAbstractDao<Style> getDao()
   {
      return styleDao;
   }

   @Override
   @Transactional(readOnly = false)
   public Style save(Style style)
   {
      Category category = categoryService.getBySid(style.getCategory().getSid());
      style.setCategory(category);
      return super.save(style);
   }
}
