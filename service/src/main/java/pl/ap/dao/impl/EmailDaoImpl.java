package pl.ap.dao.impl;

import org.springframework.stereotype.Repository;
import pl.ap.dao.IEmailDao;
import pl.ap.domain.Email;

/**
 * Created by parado on 24.03.14.
 */
@Repository(EmailDaoImpl.BEAN_NAME)
public class EmailDaoImpl extends IdentifiableDaoImpl<Email> implements IEmailDao {
    public static final String BEAN_NAME = "emailDao";
}
