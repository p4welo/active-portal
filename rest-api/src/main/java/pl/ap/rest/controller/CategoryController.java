package pl.ap.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.CourseCategory;
import pl.ap.rest.api.ApiKeys;
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
   @Resource
   private ICourseCategoryService categoryService;

   @RequestMapping(value = CompanyApiMappings.GET_CATEGORY_LIST, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   public List<CourseCategory> getCategoryList()
   {
      return categoryService.findAll();
   }

   @RequestMapping(value = CompanyApiMappings.CREATE_CATEGORY, method = RequestMethod.POST)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public CourseCategory createCategory(@RequestBody CourseCategory courseCategory)
   {
      return categoryService.save(courseCategory);
   }

   @RequestMapping(value = CompanyApiMappings.GET_CATEGORY, method = RequestMethod.PUT)
   @ResponseStatus(value = HttpStatus.OK)
   public CourseCategory updateCategory(@RequestBody CourseCategory courseCategory, @PathVariable(ApiKeys.SID) String sid)
   {
      CourseCategory oldCourseCategory = categoryService.getBySid(sid);
      Assert.notNull(oldCourseCategory);
      Assert.notNull(courseCategory);
      Assert.isTrue(sid.equals(courseCategory.getSid()));

      return categoryService.update(courseCategory);
   }
}
