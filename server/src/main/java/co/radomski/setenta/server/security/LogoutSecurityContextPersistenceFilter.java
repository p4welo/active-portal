package co.radomski.setenta.server.security;

import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.util.AntPathMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by parado on 09.04.14.
 */
public class LogoutSecurityContextPersistenceFilter extends SecurityContextPersistenceFilter
{
   public static final String DEFAULT_LOGOUT = "/logout";

   private AntPathMatcher pathMatcher = new AntPathMatcher();

   private String logoutPath = DEFAULT_LOGOUT;

   public LogoutSecurityContextPersistenceFilter(SecurityContextRepository repo)
   {
      super(repo);
   }

   @Override
   public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException
   {
      HttpServletRequest request = (HttpServletRequest) req;
      String requestPath = request.getRequestURI().replace(request.getContextPath(), "");
      if (isLogout(requestPath))
      {
         HttpSession session = request.getSession(false);
         if (session != null)
         {
            session.removeAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
         }
         chain.doFilter(req, res);
      }
      else
      {
         super.doFilter(req, res, chain);
      }
   }

   protected boolean isLogout(String url)
   {
      return pathMatcher.match(logoutPath, url);
   }

   public void setLogoutPath(String logoutPath)
   {
      this.logoutPath = logoutPath;
   }

}
