package co.radomski.setenta.server.security;

import co.radomski.setenta.domain.User;

/**
 * Created by parado on 14.04.14.
 */
public interface ISecurityService
{
   User getLoggedInUser();
}
