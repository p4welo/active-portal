package pl.ap.web.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.News;
import pl.ap.web.api.ApiKeys;
import pl.ap.web.api.NewsApiMappings;
import pl.ap.service.INewsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 26.03.14.
 * Deprecated feature in case of WordPress post management used
 */
@RestController
@Deprecated
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

    @RequestMapping(value = NewsApiMappings.FIND_PUBLIC, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<News> findPublic() {
        LOGGER.info("findPublic()");
        return newsService.findPublic();
    }

    @RequestMapping(value = NewsApiMappings.CREATE, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public News create(@RequestBody News news) {
        LOGGER.info("create()");

        Assert.notNull(news.getTitle());
        Assert.notNull(news.getContent());

        return newsService.save(news);
    }

    @RequestMapping(value = NewsApiMappings.GET, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public News get(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("get()");
        return newsService.getBySid(sid);
    }

    @RequestMapping(value = NewsApiMappings.PUBLISH, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public News publish(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("publish()");

        News news = newsService.getBySid(sid);
        Assert.notNull(news);

        return newsService.publish(news);
    }

    @RequestMapping(value = NewsApiMappings.DEACTIVATE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public News deactivate(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("deactivate()");

        News news = newsService.getBySid(sid);
        Assert.notNull(news);

        return newsService.deactivate(news);
    }

    @RequestMapping(value = NewsApiMappings.UPDATE, method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public News update(@RequestBody News news, @PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("update()");

        Assert.notNull(newsService.getBySid(sid));
        Assert.notNull(news);
        Assert.isTrue(sid.equals(news.getSid()));
        
        return newsService.update(news);
    }

    @RequestMapping(value = NewsApiMappings.DELETE, method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    @Secured("hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("delete()");

        News news = newsService.getBySid(sid);
        Assert.notNull(news);

        newsService.delete(news);
    }
}
