package co.radomski.setenta.service.impl;

import co.radomski.setenta.dao.IAbstractDao;
import co.radomski.setenta.dao.IEmailDao;
import co.radomski.setenta.domain.Email;
import co.radomski.setenta.service.IEmailService;
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
