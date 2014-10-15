package pl.ap.service;

import pl.ap.domain.User;

/**
 * Created by parado on 08.04.14.
 */
public interface IUserService extends IAbstractService<User> {
    User getByLogin(String login);

    void createTestUser();
}
