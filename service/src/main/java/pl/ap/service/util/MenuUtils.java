package pl.ap.service.util;


import pl.ap.domain.menu.MenuGroup;
import pl.ap.domain.menu.MenuItem;

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

      MenuItem rooms = new MenuItem();
      rooms.setLabel("Sale taneczne");
      rooms.setIcon("fa fa-bank");
      rooms.setState("rooms");

      MenuItem instructors = new MenuItem();
      instructors.setLabel("Instruktorzy");
      instructors.setIcon("gi gi-parents");
      instructors.setState("instructors");

      MenuItem categories = new MenuItem();
      categories.setLabel("Kategorie zajęć");
      categories.setIcon("gi gi-folder_open");
      categories.setState("categories");

      MenuItem classes = new MenuItem();
      classes.setLabel("Zajęcia");
      classes.setIcon("gi gi-table");
      classes.setState("classes");

      MenuGroup group2 = new MenuGroup();
      group2.setHeader("GRAFIK");
      group2.setItems(Arrays.asList(rooms, instructors, categories, classes));

//      return Arrays.asList(group2);
      return Arrays.asList(group1,group2);
   }
}
