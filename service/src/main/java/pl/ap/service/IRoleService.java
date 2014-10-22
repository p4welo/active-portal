package pl.ap.service;

import org.springframework.transaction.annotation.Transactional;
import pl.ap.domain.Authority;
import pl.ap.domain.Role;

/**
 * Created by parado on 2014-10-16.
 */
public interface IRoleService extends IIdentifiableService<Role> {
    void checkAuthority(Role role, Authority authority);

    void uncheckAuthority(Role role, Authority authority);
}
