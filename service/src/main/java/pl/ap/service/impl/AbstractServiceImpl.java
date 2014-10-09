package pl.ap.service.impl;

import pl.ap.dao.IAbstractDao;
import pl.ap.domain.common.IdentifiableEntity;
import pl.ap.service.IAbstractService;
import pl.ap.service.util.SidUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: pawel
 * Date: 01.12.12
 * Time: 00:24
 */
@Service
public abstract class AbstractServiceImpl<T extends IdentifiableEntity> implements IAbstractService<T>
{
   protected abstract IAbstractDao<T> getDao();

   @Transactional(readOnly = false)
   public T save(T obj)
   {
      if (obj.getSid() == null)
      {
         obj.setSid(SidUtils.generate());
      }
      return getDao().save(obj);
   }

   @Transactional(readOnly = true)
   public T getRandom()
   {
      return getDao().getRandom();
   }

   @Transactional(readOnly = true)
   @Deprecated
   public T getById(Long id)
   {
      return getDao().getById(id);
   }

   @Override
   @Transactional(readOnly = true)
   public List<T> find(int first, int count, String property, boolean ascending)
   {
      return getDao().find(first, count, property, ascending);
   }

   @Override
   @Transactional(readOnly = true)
   public long getCount()
   {
      return getDao().getCount();
   }

   @Transactional(readOnly = false)
   public T update(T obj)
   {
      return getDao().update(obj);
   }

   @Transactional(readOnly = false)
   public void delete(T obj)
   {
      getDao().delete(obj);
   }

   @Transactional(readOnly = false)
   public void delete(List<T> obj)
   {
      getDao().delete(obj);
   }

//   @Transactional(readOnly = true)
   public List<T> findAll()
   {
      return getDao().findAll();
   }

   @Transactional(readOnly = true)
   public T getBySid(String sid)
   {
      return getDao().getBySid(sid);
   }

   @Override
   @Transactional(readOnly = false)
   public List<T> saveAll(List<T> entities)
   {
      return getDao().saveAll(entities);
   }

   @Override
   @Transactional(readOnly = true)
   public T getBy(String propertyName, Object value)
   {
      return getDao().getBy(propertyName, value);
   }

   @Override
   @Transactional(readOnly = true)
   public List<T> findBy(String propertyName, Object value)
   {
      return getDao().findBy(propertyName, value);
   }
}
