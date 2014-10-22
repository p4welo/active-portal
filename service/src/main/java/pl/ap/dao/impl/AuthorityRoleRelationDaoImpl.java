package pl.ap.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pl.ap.dao.IAuthorityRoleRelationDao;
import pl.ap.domain.Authority;
import pl.ap.domain.AuthorityRoleRelation;
import pl.ap.domain.Role;

import java.util.List;

/**
 * Created by parado on 2014-10-16.
 */
@Repository(AuthorityRoleRelationDaoImpl.BEAN_NAME)
public class AuthorityRoleRelationDaoImpl extends AbstractDaoImpl<AuthorityRoleRelation> implements IAuthorityRoleRelationDao {
    public static final String BEAN_NAME = "authorityRoleRelationDao";

    @Override
    public List<Authority> findAuthoritiesByRole(Role role) {
        Criteria criteria = createCriteria()
                .add(Restrictions.eq(AuthorityRoleRelation.FIELD_ROLE, role))
                .setProjection(Projections.property(AuthorityRoleRelation.FIELD_AUTHORITY));
        return criteria.list();
    }

    @Override
    public AuthorityRoleRelation get(Role role, Authority authority) {
        Criteria criteria = createCriteria()
                .add(Restrictions.eq(AuthorityRoleRelation.FIELD_ROLE, role))
                .add(Restrictions.eq(AuthorityRoleRelation.FIELD_AUTHORITY, authority));
        return (AuthorityRoleRelation) criteria.uniqueResult();
    }
}
