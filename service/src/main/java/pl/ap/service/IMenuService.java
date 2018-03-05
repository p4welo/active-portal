package pl.ap.service;

import pl.ap.domain.User;
import pl.ap.domain.menu.MenuGroup;

import java.util.List;

/**
 * Created by parado on 2014-06-06.
 */
public interface IMenuService {
    List<MenuGroup> getByUser(User user);
}
