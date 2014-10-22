package pl.ap.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.CourseCategory;
import pl.ap.rest.api.ApiKeys;
import pl.ap.rest.api.CategoryApiMappings;
import pl.ap.service.ICourseCategoryService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-08-24.
 */
@RestController
public class CategoryController {

    private static final Logger LOGGER = Logger.getLogger(CategoryController.class);

    @Resource
    private ICourseCategoryService categoryService;

    @RequestMapping(value = CategoryApiMappings.FIND_ALL, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<CourseCategory> findAll() {
        LOGGER.info("findAll()");
        return categoryService.findAll();
    }

    @RequestMapping(value = CategoryApiMappings.CREATE, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public CourseCategory create(@RequestBody CourseCategory category) {
        LOGGER.info("create()");

        Assert.notNull(category);

        return categoryService.save(category);
    }

    @RequestMapping(value = CategoryApiMappings.GET, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public CourseCategory get(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("get()");
        return categoryService.getBySid(sid);
    }

    @RequestMapping(value = CategoryApiMappings.ACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public CourseCategory activate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("activate()");

        CourseCategory category = categoryService.getBySid(sid);
        Assert.notNull(category);

        return categoryService.activate(category);
    }

    @RequestMapping(value = CategoryApiMappings.DEACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public CourseCategory deactivate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("deactivate()");

        CourseCategory category = categoryService.getBySid(sid);
        Assert.notNull(category);

        return categoryService.deactivate(category);
    }

    @RequestMapping(value = CategoryApiMappings.UPDATE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public CourseCategory update(@RequestBody CourseCategory category, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("update()");

        Assert.notNull(categoryService.getBySid(sid));
        Assert.notNull(category);
        Assert.isTrue(sid.equals(category.getSid()));

        return categoryService.update(category);
    }

    @RequestMapping(value = CategoryApiMappings.DELETE, method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("delete()");

        CourseCategory category = categoryService.getBySid(sid);
        Assert.notNull(category);

        categoryService.delete(category);
    }
}