package pl.ap.dao;

import pl.ap.domain.Authority;
import pl.ap.domain.AuthorityRoleRelation;
import pl.ap.domain.Role;

import java.util.List;

/**
 * Created by parado on 2014-10-16.
 */
public interface IAuthorityRoleRelationDao extends IAbstractDao<AuthorityRoleRelation> {
    List<Authority> findAuthoritiesByRole(Role role);

    AuthorityRoleRelation get(Role role, Authority authority);
}
