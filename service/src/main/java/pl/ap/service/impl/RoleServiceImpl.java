package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IRoleDao;
import pl.ap.domain.Role;
import pl.ap.service.IRoleService;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-16.
 */
@Service(RoleServiceImpl.BEAN_NAME)
public class RoleServiceImpl extends AbstractServiceImpl<Role> implements IRoleService {
    public static final String BEAN_NAME = "roleService";

    @Resource
    private IRoleDao roleDao;

    @Override
    protected IAbstractDao<Role> getDao() {
        return roleDao;
    }
}
