package pl.ap.server.security;

import pl.ap.domain.User;

/**
 * Created by parado on 2014-06-06.
 */
public interface ISecurityService
{
   public User getLoggedInUser();
}
