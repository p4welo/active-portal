package pl.ap.web.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.User;
import pl.ap.web.api.ApiKeys;
import pl.ap.web.api.UserApiMappings;
import pl.ap.service.IUserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-10-18.
 */
@RestController
public class UserController {
    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    @Resource
    private IUserService userService;

    @RequestMapping(value = UserApiMappings.FIND_ALL, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<User> findAll() {
        LOGGER.info("findAll()");
        return userService.findAll();
    }

    @RequestMapping(value = UserApiMappings.CREATE, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public User create(@RequestBody User user) {
        LOGGER.info("create()");

        Assert.notNull(user);

        return userService.save(user);
    }

    @RequestMapping(value = UserApiMappings.GET, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public User get(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("get()");
        return userService.getBySid(sid);
    }

    @RequestMapping(value = UserApiMappings.ACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public User activate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("activate()");

        User user = userService.getBySid(sid);
        Assert.notNull(user);

        return userService.activate(user);
    }

    @RequestMapping(value = UserApiMappings.DEACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public User deactivate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("deactivate()");

        User user = userService.getBySid(sid);
        Assert.notNull(user);

        return userService.deactivate(user);
    }

    @RequestMapping(value = UserApiMappings.UPDATE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public User update(@RequestBody User user, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("update()");

        Assert.notNull(userService.getBySid(sid));
        Assert.notNull(user);
        Assert.isTrue(sid.equals(user.getSid()));

        return userService.update(user);
    }

    @RequestMapping(value = UserApiMappings.DELETE, method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("delete()");

        User user = userService.getBySid(sid);
        Assert.notNull(user);

        userService.delete(user);
    }
}
