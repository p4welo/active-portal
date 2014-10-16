package pl.ap.dao.impl;

import org.springframework.stereotype.Repository;
import pl.ap.dao.IAuthorityRoleRelationDao;
import pl.ap.domain.AuthorityRoleRelation;

/**
 * Created by parado on 2014-10-16.
 */
@Repository(AuthorityRoleRelationDaoImpl.BEAN_NAME)
public class AuthorityRoleRelationDaoImpl extends AbstractDaoImpl<AuthorityRoleRelation> implements IAuthorityRoleRelationDao {
    public static final String BEAN_NAME = "authorityRoleRelationDao";
}
