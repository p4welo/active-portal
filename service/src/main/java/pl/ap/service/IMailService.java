package pl.ap.service;

import pl.ap.domain.Email;

import javax.mail.MessagingException;

public interface IMailService
{
   public static final String MAIL_SERVER_USERNAME = "mail.server.username";

   void sendHtmlMail(String from, String to, String subject, String body) throws MessagingException;

   void testSend();

   void sendEmail(Email email) throws MessagingException;
}
