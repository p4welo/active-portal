package co.radomski.setenta.server.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * Created by parado on 09.04.14.
 */
public class TokenAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider implements InitializingBean
{
   @Resource
   private PasswordEncoder passwordEncoder;

   private UserDetailsService userDetailsService;

   @Override
   protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                 UsernamePasswordAuthenticationToken authentication)
           throws AuthenticationException
   {
      if (!(authentication instanceof TrustedUsernamePasswordAuthenticationToken))
      {
         String password = passwordEncoder.encode(authentication.getCredentials().toString());
         if (!StringUtils.equals(userDetails.getPassword(), password))
         {
            throw new BadCredentialsException("Password for user " + userDetails.getUsername() + " did not match");
         }
      }
      {
         if (!userDetails.isEnabled())
         {
            throw new LockedException("Account for user " + userDetails.getUsername() + " is locked");
         }
      }
   }

   protected final UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
           throws AuthenticationException
   {
      UserDetails loadedUser;

      try
      {
         loadedUser = this.getUserDetailsService().loadUserByUsername(username);
      }
      catch (DataAccessException repositoryProblem)
      {
         throw new AuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
      }

      if (loadedUser == null)
      {
         throw new UsernameNotFoundException(
                 "UserDetailsService returned null, which is an interface contract violation");
      }
      return loadedUser;
   }

   public UserDetailsService getUserDetailsService()
   {
      return userDetailsService;
   }

   protected void doAfterPropertiesSet() throws Exception
   {
      Assert.notNull(this.userDetailsService, "A UserDetailsService must be set");
   }

   public void setUserDetailsService(UserDetailsService userDetailsService)
   {
      this.userDetailsService = userDetailsService;
   }
}
