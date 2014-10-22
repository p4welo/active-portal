package pl.ap.service;

import pl.ap.domain.Authority;
import pl.ap.domain.Role;

import java.util.List;

/**
 * Created by parado on 2014-10-16.
 */
public interface IAuthorityService extends IAbstractService<Authority> {
    List<Authority> findByRole(Role role);

    List<Authority> findByRoleNames(List<String> roles);
}
