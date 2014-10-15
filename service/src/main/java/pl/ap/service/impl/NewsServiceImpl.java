package pl.ap.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.INewsDao;
import pl.ap.domain.News;
import pl.ap.service.INewsService;
import pl.ap.service.util.DateTimeUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 25.03.14.
 */
@Service(NewsServiceImpl.BEAN_NAME)
public class NewsServiceImpl extends AbstractServiceImpl<News> implements INewsService {
    public static final String BEAN_NAME = "newsService";

    @Resource
    private INewsDao newsDao;

    @Override
    protected IAbstractDao<News> getDao() {
        return newsDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<News> findNewsList() {
        return newsDao.findNewsList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<News> findPublic() {
        return newsDao.findPublic();
    }

    @Override
    @Transactional(readOnly = false)
    public News publish(News news) {
//        TODO: change course state
        return newsDao.update(news);
    }

    @Override
    public News deactivate(News news) {
//        TODO: change course state
        return newsDao.update(news);
    }

    @Override
    @Transactional(readOnly = false)
    public News save(News news) {
//        TODO: ustawianie OS na INACTIVE domyślnie:
//        if (news.getObjectState == null) {
//
//        }
        if (StringUtils.isBlank(news.getCreatedAt())) {
            DateTime dateTime = new DateTime();
            news.setCreatedAt(dateTime.toString(DateTimeUtils.DATE_TIME_FORMAT));
        }
        return super.save(news);
    }

    @Override
    public News update(News n) {
        News news = getBySid(n.getSid());
        news.setTitle(n.getTitle());
        news.setContent(n.getContent());
        news.setImageAlt(n.getImageAlt());
        news.setImageSrc(n.getImageSrc());
        return super.update(news);
    }
}
