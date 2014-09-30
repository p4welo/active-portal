package pl.ap.service;


import pl.ap.domain.IdentifiableEntity;
import java.util.List;

/**
 * User: pawel
 * Date: 01.12.12
 * Time: 00:22
 */
public interface IAbstractService<T extends IdentifiableEntity>
{
   T save(T obj);

   T update(T obj);

   void delete(T obj);

   void delete(List<T> obj);

   List<T> findAll();

   T getRandom();

   T getById(Long id);

   List<T> find(int first, int count, String property, boolean ascending);

   long getCount();

   T getBySid(String sid);

   List<T> saveAll(List<T> entities);

   T getBy(String propertyName, Object value);

   List<T> findBy(String propertyName, Object value);
}
