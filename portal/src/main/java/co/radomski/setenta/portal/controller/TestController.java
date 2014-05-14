package co.radomski.setenta.portal.controller;

import co.radomski.setenta.domain.User;
import co.radomski.setenta.domain.enums.UserTypeEnum;
import co.radomski.setenta.domain.menu.MenuGroup;
import co.radomski.setenta.domain.menu.MenuItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by parado on 2014-05-01.
 */
@Controller
public class TestController
{
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public ModelAndView welcomePage()
   {
      ModelAndView model = new ModelAndView("index");
      model.addObject("menu", provideMenu());
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

   private List<MenuGroup> provideMenu()
   {
      MenuItem news = new MenuItem();
      news.setLabel("Lista");
      news.setIcon("gi gi-fire");
      news.setState("news");

      MenuGroup group1 = new MenuGroup();
      group1.setHeader("AKTUALNOSCI");
      group1.setItems(Arrays.asList(news));

      MenuItem classes = new MenuItem();
      classes.setLabel("Zajecia");
      classes.setIcon("gi gi-table");
      classes.setState("classes");

      MenuGroup group2 = new MenuGroup();
      group2.setHeader("GRAFIK");
      group2.setItems(Arrays.asList(classes));


      return Arrays.asList(group1,group2);
   }
}
