package pl.ap.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import pl.ap.dao.IAbstractDao;
import pl.ap.domain.common.DataEntity;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by parado on 2014-10-16.
 */
@ContextConfiguration(locations =
        {
                "classpath:spring/test-dao-context.xml"
        })
@Ignore
public abstract class AbstractDaoImplTest<T extends DataEntity> extends GenericDaoTest {

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
    public void testGetRandom() {
        persist(getEntities());

        T entity = getDao().getRandom();
        Assert.assertNotNull(entity);

        boolean notAllTheSame = false;
        for (int i = 0; i < 100; i++) {
            if (!entity.equals(getDao().getRandom())) {
                notAllTheSame = true;
            }
        }
        Assert.assertTrue(notAllTheSame);
    }

    @Test
    public void testFind() {
        persist(getEntities());

        List<T> result = getDao().find(5, 10, "id", false);

        Assert.assertNotNull(result);
        Assert.assertTrue(result.size() == 10);
        Assert.assertTrue(result.get(0).getId() > result.get(1).getId());

        result = getDao().find(5, 10, "id", true);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.size() == 10);
        Assert.assertTrue(result.get(0).getId() < result.get(1).getId());
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

//    protected abstract List<T> getEntities();

    protected List<T> getEntities() {
        List<T> entities = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            entities.add(getEntity());
        }
        return entities;
    }

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
