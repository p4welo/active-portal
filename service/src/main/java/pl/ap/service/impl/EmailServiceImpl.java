package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import pl.ap.dao.IEmailDao;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.domain.CustomerFeedback;
import pl.ap.domain.Email;
import pl.ap.service.IEmailService;
import pl.ap.service.IMailService;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * Created by parado on 24.03.14.
 */
@Service(EmailServiceImpl.BEAN_NAME)
public class EmailServiceImpl extends IdentifiableServiceImpl<Email> implements IEmailService {
    public static final String BEAN_NAME = "emailService";

    @Resource
    private IEmailDao emailDao;

    @Resource
    private IMailService mailService;

    @Override
    protected IIdentifiableDao<Email> getDao() {
        return emailDao;
    }

    @Override
    protected String[] getUpdateFields() {
        return new String[]{
                Email.FIELD_OBJECT_STATE,
                Email.FIELD_SENDER,
                Email.FIELD_SUBJECT,
                Email.FIELD_CONTENT
        };
    }

    @Override
    public void customerFeedback(CustomerFeedback feedback) throws MessagingException {
        StringBuilder builder = new StringBuilder("OPINIA KLIENTA");
        builder.append("<br />======");
        builder.append("<br /><br />");
        builder.append("OCENA: " + feedback.getRate());
        builder.append("<br />");
        if (feedback.getType() != null) {
            builder.append("TYP: " + feedback.getType());
            builder.append("<br />");
        }
        if (feedback.getDescription() != null) {
            builder.append("OPIS: " + feedback.getDescription());
        }

        String[] recipients = new String[]{
                "p4welo@gmail.com"
        };
        Email email = new Email("p4welo@gmail.com", recipients, "SETENTA - OPINIA KLIENTA", builder.toString());
        mailService.sendEmail(email);
    }
}