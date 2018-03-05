package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IPasswordDao;
import pl.ap.domain.Password;
import pl.ap.service.IPasswordService;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-15.
 */
@Service(PasswordServiceImpl.BEAN_NAME)
public class PasswordServiceImpl extends AbstractServiceImpl<Password> implements IPasswordService {

    public static final String BEAN_NAME = "passwordService";

    @Resource
    private IPasswordDao passwordDao;

    @Override
    protected IAbstractDao<Password> getDao() {
        return passwordDao;
    }
}
