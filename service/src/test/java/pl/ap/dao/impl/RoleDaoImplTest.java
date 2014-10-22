package pl.ap.dao.impl;

import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IRoleDao;
import pl.ap.dao.TestDomainObjectFactory;
import pl.ap.domain.common.DataEntity;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-16.
 */
public class RoleDaoImplTest extends AbstractDaoImplTest {

    @Resource
    private IRoleDao roleDao;

    @Override
    protected IAbstractDao getDao() {
        return roleDao;
    }

    @Override
    protected DataEntity getEntity() {
        return TestDomainObjectFactory.getRole();
    }
}
