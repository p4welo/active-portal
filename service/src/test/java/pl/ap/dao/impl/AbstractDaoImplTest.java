package pl.ap.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import pl.ap.dao.IAbstractDao;
import pl.ap.domain.common.DataEntity;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by parado on 2014-10-16.
 */
@ContextConfiguration(locations =
        {
                "classpath:spring/test-dao-context.xml"
        })
@Ignore
public abstract class AbstractDaoImplTest<T extends DataEntity> extends DaoTest {

    @Resource
    protected SessionFactory sessionFactory;

    @Test
    public void testGetByIdUsingCriteria() {
        List<T> entities = getEntities();
        persist(entities);
        int randomIndex = new Random().nextInt(entities.size());
        T entity = entities.get(randomIndex);

        T result = getDao().getById(entity.getId());

        assertNotNull(result);
        assertEquals(entity, result);
    }

    @Test
    public void testSave() {
        T expected = getDao().save(getEntity());

        DataEntity result = getDao().getById(expected.getId());

        assertNotNull(result.getId());
        assertEquals(expected, result);
    }

    @Test
    public void testGetById() {
        T expected = getEntity();
        persist(expected);

        T result = getDao().getById(expected.getId());

        assertEquals(expected, result);
    }

    @Test
    public void testDelete() {
        T entity = getEntity();
        persist(entity);

        T result = getDao().getById(entity.getId());
        assertNotNull(result);

        getDao().delete(entity);

        result = getDao().getById(entity.getId());
        assertNull(result);
    }

    protected abstract IAbstractDao<T> getDao();

    protected abstract T getEntity();

    protected abstract List<T> getEntities();


    protected void persist(DataEntity... entries) {
        Session session = sessionFactory.getCurrentSession();
        for (DataEntity entry : entries) {
            session.saveOrUpdate(entry);
        }
    }

    protected void persist(List<?> entries) {
        Session session = sessionFactory.getCurrentSession();
        for (Object entry : entries) {
            session.saveOrUpdate(entry);
        }
    }
}
