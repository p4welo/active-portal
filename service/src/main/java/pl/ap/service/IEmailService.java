package pl.ap.service;

import pl.ap.domain.CustomerFeedback;
import pl.ap.domain.Email;

import javax.mail.MessagingException;

/**
 * Created by parado on 24.03.14.
 */
public interface IEmailService extends IIdentifiableService<Email> {
    void customerFeedback(CustomerFeedback feedback) throws MessagingException;
}
