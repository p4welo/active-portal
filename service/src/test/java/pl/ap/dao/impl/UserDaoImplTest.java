package pl.ap.dao.impl;

import org.junit.Before;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.IUserDao;
import pl.ap.dao.TestDomainObjectFactory;
import pl.ap.domain.Role;
import pl.ap.domain.User;

import javax.annotation.Resource;

/**
 * ł
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 10.09.13
 * Time: 23:30
 * To change this template use File | Settings | File Templates.
 */
public class UserDaoImplTest extends IdentifiableDaoImplTest<User> {
    @Resource
    private IUserDao userDao;

    private Role role;

    @Override
    protected IIdentifiableDao<User> getDao() {
        return userDao;
    }

    @Before
    public void setup() {
        role = TestDomainObjectFactory.getRole();
        persist(role);
    }

    @Override
    protected User getEntity() {

        return TestDomainObjectFactory.getUser(role);
    }
}
