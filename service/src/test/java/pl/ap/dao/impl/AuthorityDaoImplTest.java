package pl.ap.dao.impl;

import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IAuthorityDao;
import pl.ap.factory.TestDomainObjectFactory;
import pl.ap.domain.Authority;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-16.
 */
public class AuthorityDaoImplTest extends AbstractDaoImplTest<Authority> {
    @Resource
    private IAuthorityDao authorityDao;

    @Override
    protected IAbstractDao<Authority> getDao() {
        return authorityDao;
    }

    @Override
    protected Authority getEntity() {
        return TestDomainObjectFactory.getAuthority();
    }
}
