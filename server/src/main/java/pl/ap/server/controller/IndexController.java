package pl.ap.server.controller;

import pl.ap.domain.User;
import pl.ap.server.security.ISecurityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.ap.service.IMenuService;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-05-01.
 */
@Controller
public class IndexController
{
   @Resource
   private ISecurityService securityService;

   @Resource
   private IMenuService menuService;

   @RequestMapping(value = "/", method = RequestMethod.GET)
   public ModelAndView welcomePage()
   {
      ModelAndView model = new ModelAndView("index");
      User user = securityService.getLoggedInUser();
      model.addObject("menu", menuService.getByUser(user));
      model.addObject("user", user);
      return model;
   }

   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public ModelAndView login()
   {
      return new ModelAndView("login");
   }
}
