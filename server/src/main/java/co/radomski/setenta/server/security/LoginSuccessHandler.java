package co.radomski.setenta.server.security;

import co.radomski.setenta.server.ContentType;
import co.radomski.setenta.server.HttpHeaders;
import co.radomski.setenta.server.security.token.TokenMarshaller;
import co.radomski.setenta.server.security.token.TokenParseException;
import co.radomski.setenta.server.security.token.UserToken;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by parado on 09.04.14.
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler
        implements InitializingBean
{
   public static final String BEAN_NAME = "loginSuccessHandler";

   private static final Logger LOGGER = Logger.getLogger(LoginSuccessHandler.class);

   private String cookieName;

   private int cookieTimeout;

   @Resource
   private TokenMarshaller tokenMarshaller;

   @Override
   public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                       Authentication authentication) throws IOException, ServletException
   {
      if (authentication != null && authentication.isAuthenticated())
      {
         if (hasClientAcceptHeader(request))
         {
            String token = makeToken(authentication);
            if (StringUtils.isNotBlank(token))
            {
               response.getWriter().write(tokenToJson(token));
            }
         }
         else
         {
            String token = makeToken(authentication);
            Cookie cookie = new Cookie(cookieName, token);
            cookie.setPath(request.getContextPath());
            cookie.setMaxAge(cookieTimeout);
            response.addCookie(cookie);
            super.onAuthenticationSuccess(request, response, authentication);
         }
      }
   }

   private String tokenToJson(String token)
   {
      StringBuilder builder = new StringBuilder();
      builder.append("{\"token\":\"");
      builder.append(cookieName);
      builder.append(" token='");
      builder.append(token);
      builder.append("'\"}");
      return builder.toString();
   }

   private String makeToken(Authentication authentication)
   {
      try
      {
         return tokenMarshaller
                 .marshall(new UserToken(((User) authentication.getPrincipal()).getUsername(), cookieTimeout));
      }
      catch (TokenParseException e)
      {
         LOGGER.error(e.getMessage(), e);
         return null;
      }
   }

   private boolean hasClientAcceptHeader(HttpServletRequest request)
   {
      Enumeration headers = request.getHeaders(HttpHeaders.ACCEPT);
      for (; headers.hasMoreElements(); )
      {
         String header = (String) headers.nextElement();
         if (StringUtils.startsWith(header, ContentType.JSON) ||
                 StringUtils.startsWith(header, ContentType.XML))
         {
            return true;
         }
      }
      return false;
   }

   public void setCookieTimeout(int cookieTimeout)
   {
      this.cookieTimeout = cookieTimeout;
   }

   public void setCookieName(String cookieName)
   {
      this.cookieName = cookieName;
   }

   @Override
   public void afterPropertiesSet() throws Exception
   {
      Assert.hasText(cookieName, "Auth token name is not specified");
   }
}
