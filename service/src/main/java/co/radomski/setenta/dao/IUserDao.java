package co.radomski.setenta.dao;

import co.radomski.setenta.domain.User;

/**
 * Created by parado on 08.04.14.
 */
public interface IUserDao extends IAbstractDao<User>
{
   User getByLogin(String login);
}
