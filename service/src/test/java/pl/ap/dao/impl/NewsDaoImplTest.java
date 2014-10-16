package pl.ap.dao.impl;

import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.INewsDao;
import pl.ap.dao.TestDomainObjectFactory;
import pl.ap.domain.News;

import javax.annotation.Resource;

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
}
