package pl.ap.service.impl;

import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IStyleDao;
import pl.ap.domain.Style;
import pl.ap.service.IStyleService;
import org.springframework.stereotype.Service;

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

   @Override
   protected IAbstractDao<Style> getDao()
   {
      return styleDao;
   }
}
