package pl.ap.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Style;
import pl.ap.rest.api.ApiKeys;
import pl.ap.rest.api.CompanyApiMappings;
import pl.ap.service.IStyleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-08-24.
 */
@RestController
public class StyleController
{
   @Resource
   private IStyleService styleService;

   @RequestMapping(value = CompanyApiMappings.GET_STYLE_LIST, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   public List<Style> getStyleList()
   {
      return styleService.findAll();
   }

   @RequestMapping(value = CompanyApiMappings.CREATE_STYLE, method = RequestMethod.POST)
   @ResponseStatus(value = HttpStatus.OK)
   public Style createStyle(@RequestBody Style style)
   {
      Assert.notNull(style.getCategory());
      return styleService.save(style);
   }

   @RequestMapping(value = CompanyApiMappings.GET_STYLE, method = RequestMethod.PUT)
   @ResponseStatus(value = HttpStatus.OK)
   public Style updateStyle(@RequestBody Style style, @PathVariable(ApiKeys.SID) String sid)
   {
      Style oldStyle = styleService.getBySid(sid);
      Assert.notNull(oldStyle);
      Assert.notNull(style);
      Assert.isTrue(sid.equals(style.getSid()));

      return styleService.update(style);
   }
}
