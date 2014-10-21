package pl.ap.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.ap.domain.Role;
import pl.ap.rest.api.AuthorityApiMappings;
import pl.ap.service.IRoleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-10-21.
 */
@RestController
public class AuthorityController {
    private static final Logger LOGGER = Logger.getLogger(AuthorityController.class);

    @Resource
    private IRoleService roleService;

    @RequestMapping(value = AuthorityApiMappings.ROLES, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Role> roles() {
        LOGGER.info("roles()");
        return roleService.findAll();
    }
}
