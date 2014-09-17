package pl.ap.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.News;
import pl.ap.rest.api.ApiKeys;
import pl.ap.rest.api.CompanyApiMappings;
import pl.ap.service.INewsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 26.03.14.
 */
@RestController
public class NewsController
{
   @Resource
   private INewsService newsService;

   @RequestMapping(value = CompanyApiMappings.GET_NEWS_LIST, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   public List<News> getNewsList()
   {
      return newsService.findNewsList();
   }

   @RequestMapping(value = CompanyApiMappings.GET_NEWS, method = RequestMethod.PUT)
   @ResponseStatus(value = HttpStatus.OK)
   public News updateNews(@RequestBody News news,
                          @PathVariable(ApiKeys.SID) String sid)
   {
      News oldNews = newsService.getBySid(sid);
      Assert.notNull(oldNews);
      oldNews.setContent(news.getContent());
      oldNews.setTitle(news.getTitle());
      return newsService.update(oldNews);
   }

   @RequestMapping(value = CompanyApiMappings.CREATE_NEWS, method = RequestMethod.POST)
   @ResponseStatus(value = HttpStatus.OK)
   public News createNews(@RequestBody News news)
   {
      return newsService.save(news);
   }

}
