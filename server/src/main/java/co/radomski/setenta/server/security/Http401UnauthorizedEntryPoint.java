package co.radomski.setenta.server.security;

import co.radomski.setenta.server.ContentType;
import co.radomski.setenta.server.HttpHeaders;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by parado on 11.04.14.
 */
public class Http401UnauthorizedEntryPoint implements AuthenticationEntryPoint
{
   private static Logger LOGGER = Logger.getLogger(Http401UnauthorizedEntryPoint.class);

   private String loginPage = "/login";

   /**
    * Always returns a 401 error code to the client.
    */
   public void commence(HttpServletRequest request, HttpServletResponse response,
                        AuthenticationException ex) throws IOException,
           ServletException
   {
      if (LOGGER.isDebugEnabled())
      {
         LOGGER.debug(ex.getMessage());
      }

      if (hasClientAcceptHeader(request))
      {
         response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
      }
      else
      {
         response.sendRedirect(request.getContextPath() + loginPage);
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

   public void setLoginPage(String loginPage)
   {
      this.loginPage = loginPage;
   }
}
