package pl.ap.service.util;

import pl.ap.domain.menu.MenuGroup;
import pl.ap.domain.menu.MenuItem;

import java.util.Arrays;
import java.util.List;

/**
 * Created by parado on 2014-05-15.
 */
public class MenuUtils {
    public static List<MenuGroup> provideDefaultCompanyMenu() {
        MenuItem users = new MenuItem();
        users.setLabel("Użytkownicy");
        users.setIcon("gi gi-user");
        users.setState("users");

        MenuGroup systemGroup = new MenuGroup("SYSTEM");
        systemGroup.setItems(Arrays.asList(users));

        MenuItem news = new MenuItem();
        news.setLabel("Lista");
        news.setIcon("gi gi-fire");
        news.setState("news");

        MenuGroup newsGroup = new MenuGroup("AKTUALNOŚCI");
        newsGroup.setItems(Arrays.asList(news));

        MenuItem rooms = new MenuItem();
        rooms.setLabel("Sale taneczne");
        rooms.setIcon("fa fa-bank");
        rooms.setState("rooms");

        MenuItem instructors = new MenuItem();
        instructors.setLabel("Instruktorzy");
        instructors.setIcon("gi gi-certificate");
        instructors.setState("instructors");

        MenuItem categories = new MenuItem();
        categories.setLabel("Kategorie zajęć");
        categories.setIcon("gi gi-folder_open");
        categories.setState("categories");

        MenuItem styles = new MenuItem();
        styles.setLabel("Style taneczne");
        styles.setIcon("gi gi-eyedropper");
        styles.setState("styles");

        MenuItem classes = new MenuItem();
        classes.setLabel("Grafik zajęć");
        classes.setIcon("gi gi-table");
        classes.setState("classes");

        MenuGroup scheduleGroup = new MenuGroup("GRAFIK");
        scheduleGroup.setItems(Arrays.asList(rooms, instructors, categories, styles, classes));

        MenuItem customerBase = new MenuItem();
        customerBase.setLabel("Baza klientów");
        customerBase.setIcon("gi gi-parents");
        customerBase.setState("customerBase");

        MenuItem customerPresence = new MenuItem();
        customerPresence.setLabel("Obecności");
        customerPresence.setIcon("gi gi-check");
        customerPresence.setState("presence");

        MenuGroup customersGroup = new MenuGroup("Klienci");
        customersGroup.setItems(Arrays.asList(customerBase, customerPresence));

        return Arrays.asList(systemGroup, newsGroup, scheduleGroup, customersGroup);
    }
}
