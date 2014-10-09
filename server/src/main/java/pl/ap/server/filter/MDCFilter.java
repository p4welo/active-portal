package pl.ap.server.filter;

import org.slf4j.MDC;
import javax.servlet.*;
import java.io.IOException;

/**
 * Created by parado on 2014-10-09.
 */
public class MDCFilter implements Filter
{
   @Override
   public void init(FilterConfig filterConfig) throws ServletException
   {
   }
   @Override
   public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
           throws IOException, ServletException
   {
      String ipAddress = servletRequest.getRemoteAddr();
      if (ipAddress != null) {
         MDC.put("ipAddress", ipAddress);
      }
      try {
         filterChain.doFilter(servletRequest, servletResponse);
      } finally {
         if (ipAddress != null) {
            MDC.remove("ipAddress");
         }
      }
   }
   @Override
   public void destroy()
   {
   }
}