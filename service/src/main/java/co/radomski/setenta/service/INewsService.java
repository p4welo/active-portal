package co.radomski.setenta.service;

import co.radomski.setenta.domain.News;

import java.util.List;

/**
 * Created by parado on 25.03.14.
 */
public interface INewsService extends IAbstractService<News>
{
   List<News> findNewsList();
}
