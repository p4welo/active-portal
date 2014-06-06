package pl.ap.server.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.ap.domain.User;
import pl.ap.service.IUserService;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-06-06.
 */
@Service(SecurityServiceImpl.BEAN_NAME)
public class SecurityServiceImpl implements ISecurityService
{
   public static final String BEAN_NAME = "securityService";

   @Resource
   private IUserService userService;

   @Override
   public User getLoggedInUser()
   {
      UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
      if (authentication != null)
      {
         return userService.getByLogin(authentication.getName());
      }
      return null;
   }
}
