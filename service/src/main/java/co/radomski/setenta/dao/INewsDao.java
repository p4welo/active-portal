package co.radomski.setenta.dao;

import co.radomski.setenta.domain.News;

import java.util.List;

/**
 * Created by parado on 25.03.14.
 */
public interface INewsDao extends IAbstractDao<News>
{
   List<News> findNewsList();
}
