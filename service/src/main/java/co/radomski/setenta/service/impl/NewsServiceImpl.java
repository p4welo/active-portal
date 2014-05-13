package co.radomski.setenta.service.impl;

import co.radomski.setenta.dao.IAbstractDao;
import co.radomski.setenta.dao.INewsDao;
import co.radomski.setenta.domain.News;
import co.radomski.setenta.service.INewsService;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 25.03.14.
 */
@Service(NewsServiceImpl.BEAN_NAME)
public class NewsServiceImpl extends AbstractServiceImpl<News> implements INewsService
{
   public static final String BEAN_NAME = "newsService";

   @Resource
   private INewsDao newsDao;

   @Override
   protected IAbstractDao<News> getDao()
   {
      return newsDao;
   }

   @Override
   @Transactional(readOnly = true)
   public List<News> findNewsList()
   {
      return newsDao.findNewsList();
   }

   @Override
   @Transactional(readOnly = false)
   public News save(News news)
   {
      if (StringUtils.isBlank(news.getCreatedAt()))
      {
         DateTime dateTime = new DateTime();
         news.setCreatedAt(dateTime.toString("yyyy-MM-dd HH:mm"));
      }
      return super.save(news);
   }
}
