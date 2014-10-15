package pl.ap.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.CourseStyle;
import pl.ap.rest.api.ApiKeys;
import pl.ap.rest.api.StyleApiMappings;
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
        Assert.notNull(courseStyle.getCategory());
        return styleService.save(courseStyle);
    }

    @RequestMapping(value = StyleApiMappings.UPDATE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public CourseStyle update(@RequestBody CourseStyle courseStyle, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("update()");
        CourseStyle oldCourseStyle = styleService.getBySid(sid);
        Assert.notNull(oldCourseStyle);
        Assert.notNull(courseStyle);
        Assert.isTrue(sid.equals(courseStyle.getSid()));

        return styleService.update(courseStyle);
    }
}
