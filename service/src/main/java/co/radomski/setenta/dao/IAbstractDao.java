package co.radomski.setenta.dao;


import co.radomski.setenta.domain.DataEntity;
import co.radomski.setenta.domain.filter.AbstractFilter;
import co.radomski.setenta.domain.filter.SortFilterChain;

import java.util.List;

/**
 * User: pawel
 * Date: 30.11.12
 * Time: 23:59
 */
public interface IAbstractDao<T extends DataEntity>
{
   T save(T entity);

   T update(T entity);

   void delete(T entity);

   void delete(List<T> entities);

   void flush();

   List<T> findAll();

   T getRandom();

   T getById(Long id);

   List<T> find(int first, int count, String property, boolean ascending);

   long getCount();

   T getBySid(String sid);

   long countBySearchParams(AbstractFilter filter);

   List<T> findBySearchParams(AbstractFilter filter, SortFilterChain sortFilterChain, int offset, int limit);

   List<T> saveAll(List<T> entities);

   T getBy(String field, Object value);

   List<T> findBy(String propertyName, Object value);
}
