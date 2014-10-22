package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.ICustomerPresenceDao;
import pl.ap.domain.CustomerPresence;
import pl.ap.service.ICustomerPresenceService;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-17.
 */
@Service(CustomerPresenceServiceImpl.BEAN_NAME)
public class CustomerPresenceServiceImpl extends AbstractServiceImpl<CustomerPresence> implements ICustomerPresenceService {
    public static final String BEAN_NAME = "customerPresenceService";

    @Resource
    private ICustomerPresenceDao customerPresenceDao;

    @Override
    protected IAbstractDao<CustomerPresence> getDao() {
        return customerPresenceDao;
    }
}
