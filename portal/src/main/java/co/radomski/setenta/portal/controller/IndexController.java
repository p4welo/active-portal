package co.radomski.setenta.portal.controller;

import co.radomski.setenta.domain.User;
import co.radomski.setenta.domain.enums.UserTypeEnum;
import co.radomski.setenta.portal.utils.MenuUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by parado on 2014-05-01.
 */
@Controller
public class IndexController
{
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public ModelAndView welcomePage()
   {
      ModelAndView model = new ModelAndView("index");
      model.addObject("menu", MenuUtils.provideDefaultCompanyMenu());
      model.addObject("user", provideUser());
      return model;
   }

   private User provideUser()
   {
      User user = new User();
      user.setFirstName("Pawel");
      user.setLastName("Radomski");
      user.setType(UserTypeEnum.ROLE_COMPANY);
      return user;
   }

   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public ModelAndView login()
   {
      return new ModelAndView("login");
   }
}
