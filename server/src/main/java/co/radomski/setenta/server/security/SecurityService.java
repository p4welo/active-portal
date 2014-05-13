package co.radomski.setenta.server.security;

import co.radomski.setenta.domain.User;
import co.radomski.setenta.service.IUserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by parado on 14.04.14.
 */
@Service(SecurityService.BEAN_NAME)
public class SecurityService implements ISecurityService
{
   public static final String BEAN_NAME = "securityService";

   @Resource
   private IUserService userService;

   public User getLoggedInUser()
   {
      UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) SecurityContextHolder
              .getContext().getAuthentication();
      return userService.getByLogin(auth.getName());
   }
}
