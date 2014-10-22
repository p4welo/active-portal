package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IAuthorityDao;
import pl.ap.dao.IAuthorityRoleRelationDao;
import pl.ap.domain.Authority;
import pl.ap.domain.AuthorityRoleRelation;
import pl.ap.domain.Role;
import pl.ap.service.IAuthorityService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-10-16.
 */
@Service(AuthorityServiceImpl.BEAN_NAME)
public class AuthorityServiceImpl extends AbstractServiceImpl<Authority> implements IAuthorityService {
    public static final String BEAN_NAME = "authorityService";

    @Resource
    private IAuthorityDao authorityDao;

    @Resource
    private IAuthorityRoleRelationDao authorityRoleRelationDao;

    @Override
    protected IAbstractDao<Authority> getDao() {
        return authorityDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Authority> findByRole(Role role) {
        return authorityRoleRelationDao.findAuthoritiesByRole(role);
    }
}
