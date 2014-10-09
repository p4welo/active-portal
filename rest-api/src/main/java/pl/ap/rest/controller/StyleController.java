package pl.ap.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.CourseStyle;
import pl.ap.rest.api.ApiKeys;
import pl.ap.rest.api.CompanyApiMappings;
import pl.ap.service.ICourseStyleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-08-24.
 */
@RestController
public class StyleController
{
   private static final Logger LOGGER = Logger.getLogger(StyleController.class);

   @Resource
   private ICourseStyleService styleService;

   @RequestMapping(value = CompanyApiMappings.GET_STYLE_LIST, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   public List<CourseStyle> getStyleList()
   {
      LOGGER.info("getStyleList()");
      return styleService.findAll();
   }

   @RequestMapping(value = CompanyApiMappings.CREATE_STYLE, method = RequestMethod.POST)
   @ResponseStatus(value = HttpStatus.OK)
   public CourseStyle createStyle(@RequestBody CourseStyle courseStyle)
   {
      LOGGER.info("createStyle()");
      Assert.notNull(courseStyle.getCategory());
      return styleService.save(courseStyle);
   }

   @RequestMapping(value = CompanyApiMappings.GET_STYLE, method = RequestMethod.PUT)
   @ResponseStatus(value = HttpStatus.OK)
   public CourseStyle updateStyle(@RequestBody CourseStyle courseStyle, @PathVariable(ApiKeys.SID) String sid)
   {
      LOGGER.info("updateStyle()");
      CourseStyle oldCourseStyle = styleService.getBySid(sid);
      Assert.notNull(oldCourseStyle);
      Assert.notNull(courseStyle);
      Assert.isTrue(sid.equals(courseStyle.getSid()));

      return styleService.update(courseStyle);
   }
}
