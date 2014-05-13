package co.radomski.setenta.dao.impl;

import co.radomski.setenta.dao.IStyleDao;
import co.radomski.setenta.domain.Style;
import org.springframework.stereotype.Repository;

/**
 * Created by parado on 19.03.14.
 */
@Repository(StyleDaoImpl.BEAN_NAME)
public class StyleDaoImpl extends AbstractDaoImpl<Style> implements IStyleDao
{
   public static final String BEAN_NAME = "styleDao";
}
