package co.radomski.setenta.server.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Created by parado on 16.04.14.
 */
public class LogoutSessionHandler implements LogoutHandler
{
   private final List<String> cookiesToClear;

   public LogoutSessionHandler(String... cookiesToClear)
   {
      Assert.notNull(cookiesToClear, "List of cookies cannot be null");
      this.cookiesToClear = Arrays.asList(cookiesToClear);
   }

   public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
   {
      for (String cookieName : cookiesToClear)
      {
         Cookie cookie = new Cookie(cookieName, null);
         String cookiePath = request.getContextPath();
         if (!StringUtils.hasLength(cookiePath))
         {
            cookiePath = "/";
         }
         cookie.setPath(cookiePath);
         cookie.setMaxAge(0);
         response.addCookie(cookie);
      }
   }
}
