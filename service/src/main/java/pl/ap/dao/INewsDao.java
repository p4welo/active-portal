package pl.ap.dao;

import pl.ap.domain.News;

import java.util.List;

/**
 * Created by parado on 25.03.14.
 */
public interface INewsDao extends IIdentifiableDao<News> {
    List<News> findNewsList();

    List<News> findPublic();
}
