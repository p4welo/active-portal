package co.radomski.setenta.server.security;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by parado on 11.04.14.
 */
public class Http403ForbiddenAccessDeniedHandler implements AccessDeniedHandler
{
   private static Logger LOGGER = Logger.getLogger(Http403ForbiddenAccessDeniedHandler.class);

   @Override
   public void handle(HttpServletRequest request, HttpServletResponse response,
                      AccessDeniedException accessDeniedException) throws IOException, ServletException
   {
      if (LOGGER.isDebugEnabled())
      {
         LOGGER.debug(accessDeniedException.getMessage());
      }
      response.sendError(HttpServletResponse.SC_FORBIDDEN);
   }
}
