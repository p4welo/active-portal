package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IEmailDao;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.domain.Email;
import pl.ap.service.IEmailService;

import javax.annotation.Resource;

/**
 * Created by parado on 24.03.14.
 */
@Service(EmailServiceImpl.BEAN_NAME)
public class EmailServiceImpl extends IdentifiableServiceImpl<Email> implements IEmailService {
    public static final String BEAN_NAME = "emailService";

    @Resource
    private IEmailDao emailDao;

    @Override
    protected IIdentifiableDao<Email> getDao() {
        return emailDao;
    }

    @Override
    protected String[] getUpdateFields() {
        return new String[] {
                Email.FIELD_OBJECT_STATE,
                Email.FIELD_SENDER,
                Email.FIELD_SUBJECT,
                Email.FIELD_CONTENT
        };
    }
}
