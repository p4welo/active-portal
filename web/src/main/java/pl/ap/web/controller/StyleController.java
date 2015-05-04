package pl.ap.web.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Course;
import pl.ap.domain.CourseCategory;
import pl.ap.domain.CourseStyle;
import pl.ap.web.api.ApiKeys;
import pl.ap.web.api.StyleApiMappings;
import pl.ap.service.ICourseService;
import pl.ap.service.ICourseStyleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-08-24.
 */
@RestController
public class StyleController {
    private static final Logger LOGGER = Logger.getLogger(StyleController.class);

    @Resource
    private ICourseStyleService styleService;

    @Resource
    private ICourseService courseService;

    @RequestMapping(value = StyleApiMappings.FIND_ALL, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<CourseStyle> findAll() {
        LOGGER.info("findAll()");
        return styleService.findAll();
    }

    @RequestMapping(value = StyleApiMappings.CREATE, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public CourseStyle create(@RequestBody CourseStyle courseStyle) {
        LOGGER.info("create()");

        Assert.notNull(courseStyle);
        Assert.notNull(courseStyle.getCategory());

        return styleService.save(courseStyle);
    }

    @RequestMapping(value = StyleApiMappings.GET, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public CourseStyle get(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("get()");
        return styleService.getBySid(sid);
    }

    @RequestMapping(value = StyleApiMappings.ACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public CourseStyle activate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("activate()");

        CourseStyle style = styleService.getBySid(sid);
        Assert.notNull(style);

        return styleService.activate(style);
    }

    @RequestMapping(value = StyleApiMappings.DEACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public CourseStyle deactivate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("deactivate()");

        CourseStyle style = styleService.getBySid(sid);
        Assert.notNull(style);

        return styleService.deactivate(style);
    }

    @RequestMapping(value = StyleApiMappings.FIND_COURSES, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Course> findCourses(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("findCourses()");

        CourseStyle style = styleService.getBySid(sid);
        Assert.notNull(style);

        return courseService.findBy(Course.FIELD_STYLE, style);
    }

    @RequestMapping(value = StyleApiMappings.FIND_ACTIVE_COURSES, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Course> findActiveCourses(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("findActiveCourses()");

        CourseStyle style = styleService.getBySid(sid);
        Assert.notNull(style);

        return styleService.findActiveByStyle(style);
    }

    @RequestMapping(value = StyleApiMappings.SET_CATEGORY, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public CourseStyle setCategory(@RequestBody CourseCategory category, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("setCategory()");

        CourseStyle style = styleService.getBySid(sid);
        Assert.notNull(style);
        Assert.notNull(category);

        return styleService.setCategory(style, category);
    }

    @RequestMapping(value = StyleApiMappings.UPDATE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public CourseStyle update(@RequestBody CourseStyle style, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("update()");

        Assert.notNull(styleService.getBySid(sid));
        Assert.notNull(style);
        Assert.isTrue(sid.equals(style.getSid()));

        return styleService.update(style);
    }

    @RequestMapping(value = StyleApiMappings.DELETE, method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("delete()");

        CourseStyle style = styleService.getBySid(sid);
        Assert.notNull(style);

        styleService.delete(style);
    }
}
