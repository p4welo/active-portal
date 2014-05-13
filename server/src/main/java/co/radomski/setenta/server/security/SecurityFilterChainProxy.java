package co.radomski.setenta.server.security;

import org.springframework.security.web.FilterChainProxy;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by parado on 09.04.14.
 */
public class SecurityFilterChainProxy extends FilterChainProxy
{
   private AntPathMatcher pathMatcher;

   private List<String> excludeList;

   @Override
   public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
           throws IOException, ServletException
   {
      HttpServletRequest request = (HttpServletRequest) servletRequest;
      String requestPath = request.getRequestURI().replace(request.getContextPath(), "");
      if (isSecured(requestPath))
      {
         super.doFilter(servletRequest, servletResponse, chain);
      }
      else
      {
         chain.doFilter(servletRequest, servletResponse);
      }
   }

   protected boolean isSecured(String url)
   {
      for (String requestPath : excludeList)
      {
         if (getMatcher().match(requestPath, url))
         {
            return false;
         }
      }
      return true;
   }

   protected PathMatcher getMatcher()
   {
      if (pathMatcher == null)
      {
         pathMatcher = new AntPathMatcher();
      }
      return pathMatcher;
   }

   public void setExcludeList(List<String> excludeList)
   {
      this.excludeList = excludeList;
   }
}
