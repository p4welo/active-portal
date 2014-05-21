package pl.ap.server.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.ap.domain.User;
import pl.ap.service.IUserService;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * Created by parado on 2014-05-21.
 */
@Service(UserDetailsServiceImpl.BEAN_NAME)
public class UserDetailsServiceImpl implements UserDetailsService
{
   public static final String BEAN_NAME = "userDetailsService";

   @Resource
   private IUserService userService;

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
   {
      User user = userService.getByLogin(username);
      if (user != null)
      {
         return new org.springframework.security.core.userdetails.User(
                 username,
                 user.getPassword(),
                 Arrays.asList(new SimpleGrantedAuthority(user.getType().toString()))
         );
      }
      return null;
   }
}
