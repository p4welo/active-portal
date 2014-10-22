package pl.ap.dao.impl;

import org.springframework.stereotype.Repository;
import pl.ap.dao.IAuthorityDao;
import pl.ap.domain.Authority;

/**
 * Created by parado on 2014-10-16.
 */
@Repository(AuthorityDaoImpl.BEAN_NAME)
public class AuthorityDaoImpl extends AbstractDaoImpl<Authority> implements IAuthorityDao {
    public static final String BEAN_NAME = "authorityDao";
}
