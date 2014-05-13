package co.radomski.setenta.dao.impl;

import co.radomski.setenta.dao.IEmailDao;
import co.radomski.setenta.domain.Email;
import org.springframework.stereotype.Repository;

/**
 * Created by parado on 24.03.14.
 */
@Repository(EmailDaoImpl.BEAN_NAME)
public class EmailDaoImpl extends AbstractDaoImpl<Email> implements IEmailDao
{
   public static final String BEAN_NAME = "emailDao";
}
