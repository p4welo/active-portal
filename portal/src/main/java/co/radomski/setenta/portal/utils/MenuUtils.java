package co.radomski.setenta.portal.utils;

import co.radomski.setenta.domain.menu.MenuGroup;
import co.radomski.setenta.domain.menu.MenuItem;

import java.util.Arrays;
import java.util.List;

/**
 * Created by parado on 2014-05-15.
 */
public class MenuUtils
{
   public static List<MenuGroup> provideDefaultCompanyMenu()
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
