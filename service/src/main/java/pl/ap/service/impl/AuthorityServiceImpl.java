package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IAuthorityDao;
import pl.ap.domain.Authority;
import pl.ap.service.IAuthorityService;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-16.
 */
@Service(AuthorityServiceImpl.BEAN_NAME)
public class AuthorityServiceImpl extends AbstractServiceImpl<Authority> implements IAuthorityService {
    public static final String BEAN_NAME = "authorityService";

    @Resource
    private IAuthorityDao authorityDao;

    @Override
    protected IAbstractDao<Authority> getDao() {
        return authorityDao;
    }
}
