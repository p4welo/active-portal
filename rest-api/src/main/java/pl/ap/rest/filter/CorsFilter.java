package pl.ap.rest.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by parado on 2014-06-12.
 */
public class CorsFilter implements Filter
{
   public void destroy()
   {
   }

   public static String VALID_METHODS = "GET, PUT, POST, DELETE";

   public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
           throws ServletException, IOException
   {
      HttpServletRequest httpReq = (HttpServletRequest) req;
      HttpServletResponse httpResp = (HttpServletResponse) resp;

      // No Origin header present means this is not a cross-domain request
      String origin = httpReq.getHeader("Origin");
      if (origin == null)
      {
         // Return standard response if OPTIONS request w/o Origin header
         if ("OPTIONS".equalsIgnoreCase(httpReq.getMethod()))
         {
            httpResp.setHeader("Allow", VALID_METHODS);
            httpResp.setStatus(200);
            return;
         }
      }
      else
      {
         // This is a cross-domain request, add headers allowing access
         httpResp.setHeader("Access-Control-Allow-Origin", origin);
         httpResp.setHeader("Access-Control-Allow-Methods", VALID_METHODS);

         String headers = httpReq.getHeader("Access-Control-Request-Headers");
         if (headers != null)
         {
            httpResp.setHeader("Access-Control-Allow-Headers", headers);
         }

         // Allow caching cross-domain permission
         httpResp.setHeader("Access-Control-Max-Age", "3600");
      }
      // Pass request down the chain, except for OPTIONS
      if (!"OPTIONS".equalsIgnoreCase(httpReq.getMethod()))
      {
         chain.doFilter(req, resp);
      }
   }

   public void init(FilterConfig config) throws ServletException
   {

   }
}
