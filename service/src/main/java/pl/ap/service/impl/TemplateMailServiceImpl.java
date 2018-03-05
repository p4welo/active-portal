package pl.ap.service.impl;

import pl.ap.service.IMailService;
import pl.ap.service.ITemplateMailService;

import javax.annotation.Resource;

/**
 * User: pawel.radomski
 * Date: 26.11.13
 * Time: 17:26
 */
public class TemplateMailServiceImpl implements ITemplateMailService {
    public static final String BEAN_NAME = "templateMailService";

    @Resource
    private IMailService mailService;

    private String sender;

    public void setSender(String sender) {
        this.sender = sender;
    }
}
