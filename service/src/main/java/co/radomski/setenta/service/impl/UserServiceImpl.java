package co.radomski.setenta.service.impl;

import co.radomski.setenta.dao.IAbstractDao;
import co.radomski.setenta.dao.IUserDao;
import co.radomski.setenta.domain.User;
import co.radomski.setenta.domain.enums.UserTypeEnum;
import co.radomski.setenta.service.IUserService;
import co.radomski.setenta.service.util.SidUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by parado on 08.04.14.
 */
@Service(UserServiceImpl.BEAN_NAME)
public class UserServiceImpl extends AbstractServiceImpl<User> implements IUserService
{
   public static final String BEAN_NAME = "userService";

   @Resource
   private PasswordEncoder passwordEncoder;

   @Resource
   private IUserDao userDao;

   @Override
   protected IAbstractDao<User> getDao()
   {
      return userDao;
   }

   @Override
   @Transactional(readOnly = true)
   public User getByLogin(String login)
   {
      return userDao.getByLogin(login);
   }

   @Override
   @Transactional(readOnly = false)
   public void createTestUser()
   {
      User user = new User();
      user.setSid(SidUtils.generate());
      user.setFirstName("User");
      user.setLastName("Testowy");
      user.setLogin("test");
      user.setPassword(passwordEncoder.encode("test"));
      user.setType(UserTypeEnum.ROLE_ADMIN);
      user.setEmail("test@mail.com");
      save(user);
   }
}
