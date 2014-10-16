package pl.ap.dao;

import pl.ap.domain.Role;
import pl.ap.domain.User;
import pl.ap.domain.enums.ObjectStateEnum;
import pl.ap.service.util.SidUtils;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 10.09.13
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */
public class TestDomainObjectFactory {

    public static Role getRole() {
        Role role = new Role();
        role.setName("Administrator");
        return role;
    }

    public static User getUser(Role role) {
        User user = new User();
        user.setSid(SidUtils.generate());
        user.setObjectState(ObjectStateEnum.ACTIVE);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setEmail("contact@makfilm.com");
        user.setLogin("login");
        user.setPassword("VeryLongPassword");
        user.setRole(role);
        return user;
    }
}
