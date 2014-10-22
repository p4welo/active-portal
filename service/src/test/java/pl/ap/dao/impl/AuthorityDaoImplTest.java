package pl.ap.dao.impl;

import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IAuthorityDao;
import pl.ap.dao.TestDomainObjectFactory;
import pl.ap.domain.Authority;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
