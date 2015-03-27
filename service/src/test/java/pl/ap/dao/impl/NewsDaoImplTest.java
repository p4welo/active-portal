package pl.ap.dao.impl;

import org.junit.Assert;
import org.junit.Test;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.INewsDao;
import pl.ap.factory.TestDomainObjectFactory;
import pl.ap.domain.News;
import pl.ap.domain.enums.ObjectStateEnum;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-10-16.
 */
public class NewsDaoImplTest extends IdentifiableDaoImplTest<News> {
    @Resource
    private INewsDao newsDao;

    @Override
    protected IIdentifiableDao<News> getDao() {
        return newsDao;
    }

    @Override
    protected News getEntity() {
        return TestDomainObjectFactory.getNews();
    }

    @Test
    public void testFindPublic() {
        News news = getEntity();
        persist(news);
        News wrongNews = getEntity();
        wrongNews.setObjectState(ObjectStateEnum.INACTIVE);
        persist(wrongNews);

        List<News> result = newsDao.findPublic();

        Assert.assertNotNull(result);
        Assert.assertTrue(result.size() == 1);
    }
}
