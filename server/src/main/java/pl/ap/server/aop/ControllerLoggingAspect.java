package pl.ap.server.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by parado on 2014-05-14.
 */
@Aspect
//@Component
public class ControllerLoggingAspect
{
//   @Before("execution(* co.radomski.setenta.portal.web.TestController.login(..))")
//   public void logBefore(JoinPoint joinPoint) {
//
//      System.out.println("logBefore() is running!");
//      System.out.println("hijacked : " + joinPoint.getSignature().getName());
//      System.out.println("******");
//      Logger.getLogger(this.getClass()).error("========================DUPA");
//   }
}
