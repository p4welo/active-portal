package pl.ap.dao.impl;

import pl.ap.dao.IEmailDao;
import pl.ap.domain.Email;
import org.springframework.stereotype.Repository;

/**
 * Created by parado on 24.03.14.
 */
@Repository(EmailDaoImpl.BEAN_NAME)
public class EmailDaoImpl extends AbstractDaoImpl<Email> implements IEmailDao
{
   public static final String BEAN_NAME = "emailDao";
}
