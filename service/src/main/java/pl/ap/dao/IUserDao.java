package pl.ap.dao;

import pl.ap.domain.User;

/**
 * Created by parado on 08.04.14.
 */
public interface IUserDao extends IAbstractDao<User>
{
   User getByLogin(String login);
}
