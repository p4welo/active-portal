package pl.ap.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.News;
import pl.ap.rest.api.ApiKeys;
import pl.ap.rest.api.NewsApiMappings;
import pl.ap.service.INewsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 26.03.14.
 */
@RestController
public class NewsController {
    private static final Logger LOGGER = Logger.getLogger(NewsController.class);

    @Resource
    private INewsService newsService;

    @RequestMapping(value = NewsApiMappings.FIND_ALL, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<News> findAll() {
        LOGGER.info("findAll()");
        return newsService.findNewsList();
    }

    @RequestMapping(value = NewsApiMappings.UPDATE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public News update(@RequestBody News news, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("update()");
        News oldNews = newsService.getBySid(sid);
        Assert.notNull(oldNews);
        oldNews.setContent(news.getContent());
        oldNews.setTitle(news.getTitle());
        return newsService.update(oldNews);
    }

    @RequestMapping(value = NewsApiMappings.CREATE, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public News create(@RequestBody News news) {
        LOGGER.info("create()");
        return newsService.save(news);
    }

}
