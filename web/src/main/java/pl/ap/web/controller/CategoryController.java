package pl.ap.web.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.CourseCategory;
import pl.ap.service.ICourseCategoryService;
import pl.ap.web.api.ApiKeys;
import pl.ap.web.api.CategoryApiMappings;
import pl.ap.web.api.CommonApiMappings;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-08-24.
 */
@RestController
@RequestMapping(value = CommonApiMappings.REST_PREFIX)
public class CategoryController extends AbstractController {

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
        assertNotNull(category, "category");
        return categoryService.save(category);
    }

    @RequestMapping(value = CategoryApiMappings.GET, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public CourseCategory get(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("get()");
        CourseCategory category = categoryService.getBySid(sid);
        assertSidObject(category);
        return category;
    }

    @RequestMapping(value = CategoryApiMappings.ACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public CourseCategory activate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("activate()");

        CourseCategory category = categoryService.getBySid(sid);
        assertSidObject(category);

        return categoryService.activate(category);
    }

    @RequestMapping(value = CategoryApiMappings.DEACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public CourseCategory deactivate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("deactivate()");

        CourseCategory category = categoryService.getBySid(sid);
        assertSidObject(category);

        return categoryService.deactivate(category);
    }

    @RequestMapping(value = CategoryApiMappings.UPDATE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public CourseCategory update(@RequestBody CourseCategory category, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("update()");

        assertSidObject(categoryService.getBySid(sid));
        assertNotNull(category, "category");
        assertSidIntegrity(category, sid);

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