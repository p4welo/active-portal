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
@Component
public class ControllerLoggingAspect
{
   @Before("execution(* pl.ap.server.controller.NewsController.*(..))")
   public void logBefore(JoinPoint joinPoint) {

      Logger.getLogger(joinPoint.getTarget().getClass()).debug(joinPoint.getSignature());
   }
}
