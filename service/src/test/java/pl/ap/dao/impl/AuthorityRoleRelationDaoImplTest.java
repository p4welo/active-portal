package pl.ap.dao.impl;

import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IAuthorityRoleRelationDao;
import pl.ap.dao.TestDomainObjectFactory;
import pl.ap.domain.Authority;
import pl.ap.domain.AuthorityRoleRelation;
import pl.ap.domain.Role;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-16.
 */
public class AuthorityRoleRelationDaoImplTest extends AbstractDaoImplTest<AuthorityRoleRelation> {
    @Resource
    private IAuthorityRoleRelationDao authorityRoleRelationDao;

    @Override
    protected IAbstractDao<AuthorityRoleRelation> getDao() {
        return authorityRoleRelationDao;
    }

    @Override
    protected AuthorityRoleRelation getEntity() {
        Role role = TestDomainObjectFactory.getRole();
        persist(role);
        Authority authority = TestDomainObjectFactory.getAuthority();
        persist(authority);
        return TestDomainObjectFactory.getAuthorityRoleRelation(authority, role);
    }
}
