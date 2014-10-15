package pl.ap.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.CourseCategory;
import pl.ap.rest.api.ApiKeys;
import pl.ap.rest.api.CategoryApiMappings;
import pl.ap.rest.api.CompanyApiMappings;
import pl.ap.service.ICourseCategoryService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-08-24.
 */
@RestController
public class CategoryController
{
   private static final Logger LOGGER = Logger.getLogger(CategoryController.class);

   @Resource
   private ICourseCategoryService categoryService;

   @RequestMapping(value = CategoryApiMappings.FIND_ALL, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   public List<CourseCategory> findAll()
   {
      LOGGER.info("findAll()");
      return categoryService.findAll();
   }

   @RequestMapping(value = CategoryApiMappings.CREATE, method = RequestMethod.POST)
   @ResponseStatus(value = HttpStatus.OK)
   public CourseCategory create(@RequestBody CourseCategory courseCategory)
   {
      LOGGER.info("create()");
      return categoryService.save(courseCategory);
   }

   @RequestMapping(value = CategoryApiMappings.UPDATE, method = RequestMethod.PUT)
   @ResponseStatus(value = HttpStatus.OK)
   public CourseCategory update(@RequestBody CourseCategory courseCategory, @PathVariable(ApiKeys.SID) String sid)
   {
      LOGGER.info("update()");
      CourseCategory oldCourseCategory = categoryService.getBySid(sid);
      Assert.notNull(oldCourseCategory);
      Assert.notNull(courseCategory);
      Assert.isTrue(sid.equals(courseCategory.getSid()));

      return categoryService.update(courseCategory);
   }
}
