package co.radomski.setenta.server.security;

import co.radomski.setenta.domain.User;
import co.radomski.setenta.service.IUserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * Created by parado on 09.04.14.
 */
@Service(UserDetailsServiceImpl.BEAN_NAME)
public class UserDetailsServiceImpl implements UserDetailsService
{
   public static final String BEAN_NAME = "userDetailsService";

   @Resource
   private IUserService userService;

   @Resource
   private PasswordEncoder passwordEncoder;

   @Override
   public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException
   {
      User user = userService.getByLogin(login);
      if (user != null)
      {
         org.springframework.security.core.userdetails.User result = new org.springframework.security.core.userdetails.User(
                 login, user.getPassword(),
                 Arrays.asList(new SimpleGrantedAuthority(user.getType().toString().toUpperCase())));
         return result;
      }
      return null;
   }
}
