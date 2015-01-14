package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.IPassDao;
import pl.ap.domain.Pass;
import pl.ap.service.IPassService;

import javax.annotation.Resource;

/**
 * Created by parado on 2015-01-14.
 */
@Service(PassServiceImpl.BEAN_NAME)
public class PassServiceImpl extends IdentifiableServiceImpl<Pass> implements IPassService {

    public static final String BEAN_NAME = "passService";

    @Resource
    private IPassDao passDao;


    @Override
    protected IIdentifiableDao<Pass> getDao() {
        return passDao;
    }

    @Override
    protected String[] getUpdateFields() {
        return new String[] {
                Pass.FIELD_ENTRANCES_USED,
                Pass.FIELD_OBJECT_STATE
        };
    }
}
