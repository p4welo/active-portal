package pl.ap.service.impl;

import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IEmailDao;
import pl.ap.domain.Email;
import pl.ap.service.IEmailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by parado on 24.03.14.
 */
@Service(EmailServiceImpl.BEAN_NAME)
public class EmailServiceImpl extends AbstractServiceImpl<Email> implements IEmailService
{
   public static final String BEAN_NAME = "emailService";

   @Resource
   private IEmailDao emailDao;

   @Override
   protected IAbstractDao<Email> getDao()
   {
      return emailDao;
   }
}
