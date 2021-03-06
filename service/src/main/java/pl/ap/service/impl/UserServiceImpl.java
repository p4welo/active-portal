package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.IUserDao;
import pl.ap.domain.User;
import pl.ap.domain.enums.UserTypeEnum;
import pl.ap.service.IUserService;
import pl.ap.service.util.SidUtils;

import javax.annotation.Resource;

//import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by parado on 08.04.14.
 */
@Service(UserServiceImpl.BEAN_NAME)
public class UserServiceImpl extends IdentifiableServiceImpl<User> implements IUserService {
    public static final String BEAN_NAME = "userService";

//   @Resource
//   private PasswordEncoder passwordEncoder;

    @Resource
    private IUserDao userDao;

    @Override
    protected IIdentifiableDao<User> getDao() {
        return userDao;
    }

    @Override
    protected String[] getUpdateFields() {
        return new String[] {
                User.FIELD_OBJECT_STATE,
                User.FIELD_FIRST_NAME,
                User.FIELD_LAST_NAME,
                User.FIELD_EMAIL,
                User.FIELD_ROLE
        };
    }

    @Override
    @Transactional(readOnly = true)
    public User getByLogin(String login) {
        return userDao.getByLogin(login);
    }

    @Override
    @Transactional(readOnly = false)
    public void createTestUser() {
        User user = new User();
        user.setSid(SidUtils.generate());
        user.setFirstName("User");
        user.setLastName("Testowy");
        user.setLogin("test");
        user.setPassword("test");
        user.setEmail("test@mail.com");
        save(user);
    }
}
