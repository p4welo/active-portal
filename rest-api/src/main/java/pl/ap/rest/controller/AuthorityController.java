package pl.ap.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Authority;
import pl.ap.domain.Role;
import pl.ap.rest.api.ApiKeys;
import pl.ap.rest.api.AuthorityApiMappings;
import pl.ap.rest.dto.RoleAuthorityDto;
import pl.ap.service.IAuthorityService;
import pl.ap.service.IRoleService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by parado on 2014-10-21.
 */
@RestController
public class AuthorityController {
    private static final Logger LOGGER = Logger.getLogger(AuthorityController.class);

    @Resource
    private IRoleService roleService;

    @Resource
    private IAuthorityService authorityService;

    @RequestMapping(value = AuthorityApiMappings.ROLES, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Role> roles() {
        LOGGER.info("roles()");
        return roleService.findAll();
    }

    @RequestMapping(value = AuthorityApiMappings.FIND_ALL, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Authority> findAll() {
        LOGGER.info("findAll()");
        return authorityService.findAll();
    }

    @RequestMapping(value = AuthorityApiMappings.FIND_BY_ROLE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<RoleAuthorityDto> findByRole(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("findByRole()");

        Role role = roleService.getBySid(sid);
        Assert.notNull(role);

        List<Authority> all = authorityService.findAll();
        List<Authority> authorities = authorityService.findByRole(role);

        List<RoleAuthorityDto> dtos = new ArrayList<>();
        for (Authority authority : all) {
            RoleAuthorityDto dto = new RoleAuthorityDto();
            dto.setAuthority(authority);
            dto.setChecked(authorities.contains(authority));
            dtos.add(dto);
        }
        return dtos;
    }

    @RequestMapping(value = AuthorityApiMappings.CHECK_AUTHORITY, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void checkAuthority(@RequestBody Authority authority, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("checkAuthority()");

        Role role = roleService.getBySid(sid);
        Assert.notNull(role);
        Assert.notNull(authority);

        roleService.checkAuthority(role, authority);
    }

    @RequestMapping(value = AuthorityApiMappings.UNCHECK_AUTHORITY, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void uncheckAuthority(@RequestBody Authority authority, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("uncheckAuthority()");

        Role role = roleService.getBySid(sid);
        Assert.notNull(role);
        Assert.notNull(authority);

        roleService.uncheckAuthority(role, authority);
    }
}
