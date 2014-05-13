package co.radomski.setenta.server.controller;

import co.radomski.setenta.domain.User;
import co.radomski.setenta.server.api.RestApiMappings;
import co.radomski.setenta.server.security.ISecurityService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;

/**
 * Created by parado on 14.04.14.
 */
@Controller
public class UserController
{
   @Resource
   private ISecurityService securityService;

   @RequestMapping(value = RestApiMappings.GET_CURRENT_USER, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public User getCurrentUser()
   {
      return securityService.getLoggedInUser();
   }
}
