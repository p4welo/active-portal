package co.radomski.setenta.server.security;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by parado on 09.04.14.
 */
public class AuthenticationHeaderProcessingFilter extends AuthenticationProcessingFilter
{
   public static final String AUTHORIZATION_HEADER = "Authorization";

   @SuppressWarnings("unchecked")
   protected String getToken(HttpServletRequest request)
   {
      Enumeration<String> headers = request.getHeaders(AUTHORIZATION_HEADER);
      while (headers.hasMoreElements())
      {
         String value = headers.nextElement();
         if (isSchemeSupported(value))
         {
            logAuthorizationToken(value);
            return getTokenValue(value);
         }
      }
      return null;
   }
}
