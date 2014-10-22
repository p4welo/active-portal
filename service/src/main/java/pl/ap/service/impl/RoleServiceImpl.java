package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.dao.*;
import pl.ap.domain.Authority;
import pl.ap.domain.AuthorityRoleRelation;
import pl.ap.domain.Role;
import pl.ap.service.IRoleService;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-16.
 */
@Service(RoleServiceImpl.BEAN_NAME)
public class RoleServiceImpl extends IdentifiableServiceImpl<Role> implements IRoleService {
    public static final String BEAN_NAME = "roleService";

    @Resource
    private IRoleDao roleDao;

    @Resource
    private IAuthorityDao authorityDao;

    @Resource
    private IAuthorityRoleRelationDao authorityRoleRelationDao;

    @Override
    protected IIdentifiableDao<Role> getDao() {
        return roleDao;
    }

    @Override
    protected String[] getUpdateFields() {
        return new String[0];
    }

    @Override
    @Transactional(readOnly = false)
    public void checkAuthority(Role role, Authority authority) {
        authority = authorityDao.getBy(Authority.FIELD_KEY, authority.getKey());

        AuthorityRoleRelation relation = authorityRoleRelationDao.get(role, authority);
        if (relation == null) {
            relation = new AuthorityRoleRelation();
            relation.setAuthority(authority);
            relation.setRole(role);
            authorityRoleRelationDao.save(relation);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void uncheckAuthority(Role role, Authority authority) {
        authority = authorityDao.getBy(Authority.FIELD_KEY, authority.getKey());

        AuthorityRoleRelation relation = authorityRoleRelationDao.get(role, authority);
        if (relation != null) {
            authorityRoleRelationDao.delete(relation);
        }
    }
}
