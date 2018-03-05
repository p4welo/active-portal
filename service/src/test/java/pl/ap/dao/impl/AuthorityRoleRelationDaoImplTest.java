package pl.ap.dao.impl;

import org.junit.Test;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IAuthorityRoleRelationDao;
import pl.ap.domain.Authority;
import pl.ap.domain.AuthorityRoleRelation;
import pl.ap.domain.Role;
import pl.ap.factory.TestDomainObjectFactory;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
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

    @Test
    public void testFindAuthoritiesByRole() {
        List<AuthorityRoleRelation> list = getEntities();
        persist(list);
        Role role = list.get(0).getRole();
        Authority authority = list.get(0).getAuthority();
        List<Authority> result = authorityRoleRelationDao.findAuthoritiesByRole(role);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(authority.getKey(), result.get(0).getKey());
    }

    @Test
    public void testGet() {
        List<AuthorityRoleRelation> list = getEntities();
        persist(list);
        Role role = list.get(0).getRole();
        Authority authority = list.get(0).getAuthority();
        AuthorityRoleRelation result = authorityRoleRelationDao.get(role, authority);
        assertNotNull(result);
        assertEquals(role, result.getRole());
        assertEquals(authority, result.getAuthority());
    }

    @Test
    public void testFindAuthoritiesByRoleNames() {
        List<AuthorityRoleRelation> list = getEntities();
        persist(list);
        Role role = list.get(0).getRole();
        Authority authority = list.get(0).getAuthority();
        List<Authority> result = authorityRoleRelationDao.findAuthoritiesByRoleNames(Arrays.asList(role.getName()));
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(authority.getKey(), result.get(0).getKey());
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
