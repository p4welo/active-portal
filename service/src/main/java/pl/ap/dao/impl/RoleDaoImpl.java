package pl.ap.dao.impl;

import org.springframework.stereotype.Repository;
import pl.ap.dao.IRoleDao;
import pl.ap.domain.Role;

/**
 * Created by parado on 2014-10-16.
 */
@Repository(RoleDaoImpl.BEAN_NAME)
public class RoleDaoImpl extends IdentifiableDaoImpl<Role> implements IRoleDao {
    public static final String BEAN_NAME = "roleDao";
}
