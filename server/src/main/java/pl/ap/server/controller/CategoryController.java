package pl.ap.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.CourseCategory;
import pl.ap.server.api.ApiKeys;
import pl.ap.server.api.CompanyApiMappings;
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
   private ICourseCategoryService courseCategoryService;

   @RequestMapping(value = CompanyApiMappings.GET_CATEGORY_LIST, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   public List<CourseCategory> getCategoryList()
   {
      return courseCategoryService.findAll();
   }

   @RequestMapping(value = CompanyApiMappings.CREATE_CATEGORY, method = RequestMethod.POST)
   @ResponseStatus(value = HttpStatus.OK)
   public CourseCategory createCategory(@RequestBody CourseCategory courseCategory)
   {
      return courseCategoryService.save(courseCategory);
   }

   @RequestMapping(value = CompanyApiMappings.GET_CATEGORY, method = RequestMethod.PUT)
   @ResponseStatus(value = HttpStatus.OK)
   public CourseCategory updateCategory(@RequestBody CourseCategory courseCategory, @PathVariable(ApiKeys.SID) String sid)
   {
      CourseCategory oldCourseCategory = courseCategoryService.getBySid(sid);
      Assert.notNull(oldCourseCategory);
      Assert.notNull(courseCategory);
      Assert.isTrue(sid.equals(courseCategory.getSid()));

      return courseCategoryService.update(courseCategory);
   }
}
