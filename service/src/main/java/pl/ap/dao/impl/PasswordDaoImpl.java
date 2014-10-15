package pl.ap.dao.impl;

import org.springframework.stereotype.Repository;
import pl.ap.dao.IPasswordDao;
import pl.ap.domain.Password;

/**
 * Created by parado on 2014-10-15.
 */
@Repository(PasswordDaoImpl.BEAN_NAME)
public class PasswordDaoImpl extends AbstractDaoImpl<Password> implements IPasswordDao {

    public static final String BEAN_NAME = "passwordDao";
}
