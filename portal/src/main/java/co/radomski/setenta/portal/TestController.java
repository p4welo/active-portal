package co.radomski.setenta.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by parado on 2014-05-01.
 */
@Controller
public class TestController
{
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public ModelAndView welcomePage() {

      ModelAndView model = new ModelAndView("index");
      model.addObject("title", "Spring Security Hello World");
      model.addObject("message", "This is welcome page!");
      return model;

   }

   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public ModelAndView login() {

      return new ModelAndView("login");
   }

   @RequestMapping(value = "/admin**", method = RequestMethod.GET)
   public ModelAndView adminPage() {

      ModelAndView model = new ModelAndView("admin");
      model.addObject("title", "Spring Security Hello World");
      model.addObject("message", "This is protected page!");

      return model;

   }
}
