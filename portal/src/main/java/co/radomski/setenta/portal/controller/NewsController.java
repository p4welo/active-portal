package co.radomski.setenta.portal.controller;

import co.radomski.setenta.domain.News;
import co.radomski.setenta.portal.api.ApiKeys;
import co.radomski.setenta.portal.api.RestApiMappings;
import co.radomski.setenta.service.INewsService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 26.03.14.
 */
@Controller
public class NewsController
{
   @Resource
   private INewsService newsService;

   @RequestMapping(value = RestApiMappings.GET_NEWS_LIST, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public List<News> getNewsList()
   {
      return newsService.findNewsList();
   }

   @RequestMapping(value = RestApiMappings.GET_NEWS, method = RequestMethod.PUT)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public News updateNews(@RequestBody News news,
                          @PathVariable(ApiKeys.SID) String sid)
   {
      News oldNews = newsService.getBySid(sid);
      Assert.notNull(oldNews);
      oldNews.setContent(news.getContent());
      oldNews.setTitle(news.getTitle());
      return newsService.update(oldNews);
   }

   @RequestMapping(value = RestApiMappings.CREATE_NEWS, method = RequestMethod.POST)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public News createNews(@RequestBody News news)
   {
      return newsService.save(news);
   }

}
