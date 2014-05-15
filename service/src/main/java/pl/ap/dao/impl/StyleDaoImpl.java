package pl.ap.dao.impl;

import pl.ap.dao.IStyleDao;
import pl.ap.domain.Style;
import org.springframework.stereotype.Repository;

/**
 * Created by parado on 19.03.14.
 */
@Repository(StyleDaoImpl.BEAN_NAME)
public class StyleDaoImpl extends AbstractDaoImpl<Style> implements IStyleDao
{
   public static final String BEAN_NAME = "styleDao";
}
