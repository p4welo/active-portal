package pl.ap.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Category;
import pl.ap.server.api.ApiKeys;
import pl.ap.server.api.CompanyApiMappings;
import pl.ap.service.ICategoryService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-08-24.
 */
@Controller
public class CategoryController
{
   @Resource
   private ICategoryService categoryService;

   @RequestMapping(value = CompanyApiMappings.GET_CATEGORY_LIST, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public List<Category> getCategoryList()
   {
      return categoryService.findAll();
   }

   @RequestMapping(value = CompanyApiMappings.CREATE_CATEGORY, method = RequestMethod.POST)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public Category createCategory(@RequestBody Category category)
   {
      return categoryService.save(category);
   }

   @RequestMapping(value = CompanyApiMappings.GET_CATEGORY, method = RequestMethod.PUT)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public Category updateCategory(@RequestBody Category category, @PathVariable(ApiKeys.SID) String sid)
   {
      Category oldCategory = categoryService.getBySid(sid);
      Assert.notNull(oldCategory);
      Assert.notNull(category);
      Assert.isTrue(sid.equals(category.getSid()));

      return categoryService.update(category);
   }
}
