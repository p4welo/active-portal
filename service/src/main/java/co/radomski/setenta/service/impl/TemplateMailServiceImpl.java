package co.radomski.setenta.service.impl;

import co.radomski.setenta.service.IMailService;
import co.radomski.setenta.service.ITemplateMailService;

import javax.annotation.Resource;

/**
 * User: pawel.radomski
 * Date: 26.11.13
 * Time: 17:26
 */
public class TemplateMailServiceImpl implements ITemplateMailService
{
   public static final String BEAN_NAME = "templateMailService";

   @Resource
   private IMailService mailService;

   private String sender;

   public void setSender(String sender)
   {
      this.sender = sender;
   }
}
