package pl.ap.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.INewsDao;
import pl.ap.domain.News;
import pl.ap.domain.enums.ObjectStateEnum;
import pl.ap.service.INewsService;
import pl.ap.service.util.DateTimeUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 25.03.14.
 */
@Service(NewsServiceImpl.BEAN_NAME)
public class NewsServiceImpl extends IdentifiableServiceImpl<News> implements INewsService {
    public static final String BEAN_NAME = "newsService";

    @Resource
    private INewsDao newsDao;

    @Override
    protected IIdentifiableDao<News> getDao() {
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
        news.setObjectState(ObjectStateEnum.ACTIVE);
        return super.update(news);
    }

    @Override
    @Transactional(readOnly = false)
    public News save(News news) {
        if (news.getObjectState() == null) {
            news.setObjectState(ObjectStateEnum.INACTIVE);
        }
        if (StringUtils.isBlank(news.getCreatedAt())) {
            DateTime dateTime = new DateTime();
            news.setCreatedAt(dateTime.toString(DateTimeUtils.DATE_TIME_FORMAT));
        }
        return super.save(news);
    }

    @Override
    @Transactional(readOnly = false)
    public News update(News n) {
        News news = getBySid(n.getSid());
        news.setTitle(n.getTitle());
        news.setContent(n.getContent());
        news.setImageAlt(n.getImageAlt());
        news.setImageSrc(n.getImageSrc());
        return super.update(news);
    }

    @Override
    protected String[] getUpdateFields() {
        return new String[] {
                News.FIELD_OBJECT_STATE,
                News.FIELD_TITLE,
                News.FIELD_CREATED_AT,
                News.FIELD_CONTENT,
                News.FIELD_IMAGE_SRC,
                News.FIELD_IMAGE_ALT
        };
    }
}
