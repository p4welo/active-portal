package pl.ap.dao;


import pl.ap.domain.common.DataEntity;
import pl.ap.domain.common.IdentifiableEntity;

import java.util.List;

/**
 * User: pawel
 * Date: 30.11.12
 * Time: 23:59
 */
public interface IAbstractDao<T extends DataEntity> {
    T save(T entity);

    T update(T entity);

    T merge(T entity);

    void delete(T entity);

    void delete(List<T> entities);

    void flush();

    List<T> findAll();

    T getRandom();

    T getById(Long id);

    List<T> find(int first, int count, String property, boolean ascending);

    long getCount();

    List<T> saveAll(List<T> entities);

    T getBy(String field, Object value);

    List<T> findBy(String propertyName, Object value);
}
