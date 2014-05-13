package co.radomski.setenta.service.impl;

import co.radomski.setenta.dao.IAbstractDao;
import co.radomski.setenta.dao.IStyleDao;
import co.radomski.setenta.domain.Style;
import co.radomski.setenta.service.IStyleService;
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
