package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import pl.ap.domain.User;
import pl.ap.domain.menu.MenuGroup;
import pl.ap.service.IMenuService;
import pl.ap.service.util.MenuUtils;

import java.util.List;

/**
 * Created by parado on 2014-06-06.
 */
@Service(MenuServiceImpl.BEAN_NAME)
public class MenuServiceImpl implements IMenuService {
    public static final String BEAN_NAME = "menuService";

    @Override
    public List<MenuGroup> getByUser(User user) {
        return MenuUtils.provideDefaultCompanyMenu();
//      if (UserTypeEnum.ROLE_COMPANY == user.getType())
//      {
//         return MenuUtils.provideDefaultCompanyMenu();
//      }
//      else if (UserTypeEnum.ROLE_CUSTOMER == user.getType())
//      {
//         return MenuUtils.provideDefaultCompanyMenu();
//      }
//      return null;
    }
}
