package pl.ap.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.domain.common.IdentifiableEntity;
import pl.ap.service.util.SidUtils;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * User: pawel.radomski
 * Date: 10.05.13
 * Time: 16:11
 */
@Ignore
public abstract class IdentifiableDaoImplTest<T extends IdentifiableEntity> extends AbstractDaoImplTest<T> {

    @Test
    public void getBySid() {
        T entity = getEntity();
        persist(entity);
        Assert.assertNotNull(getDao().getBySid(entity.getSid()));
    }

    @Test
    public void testGetBySidUsingCriteria() {
        List<T> entities = getEntities();
        persist(entities);
        int randomIndex = new Random().nextInt(entities.size());
        T entity = entities.get(randomIndex);

        T result = getDao().getBySid(entity.getSid());

        assertNotNull(result);
        assertEquals(entity, result);
    }

    @Test
    public void testGetBySid() {
        T expected = getEntity();
        persist(expected);

        T result = getDao().getBySid(expected.getSid());
        assertEquals(expected, result);
    }

    @Test
    public void testGetByNullSid() {
        T result = getDao().getBySid(null);
        assertNull(result);
    }

    @Test
    public void testGetByBlankSid() {
        T result = getDao().getBySid("");
        assertNull(result);
    }

    //   @Test
    public void testSaveNonUniqueSid() {
        String sameSid = SidUtils.generate();
        T object1 = getEntity();
        object1.setSid(sameSid);
        persist(object1);
        getDao().flush();

        T object1ById = getDao().getById(object1.getId());
        assertNotNull(object1ById);

        T object2 = getEntity();
        object2.setSid(sameSid);

        try {
            persist(object2);
            getDao().flush();
            fail();
        } catch (ConstraintViolationException e) {
            Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
            assertNotNull(constraintViolations);
            boolean wrongSid = false;
            for (ConstraintViolation<?> constraintViolation : constraintViolations) {
                if (IdentifiableEntity.NON_UNIQUE_SID_MESSAGE.equals(constraintViolation.getMessage())) {
                    wrongSid = true;
                    break;
                }
            }
            assertEquals(true, wrongSid);
        }
    }

    protected abstract IIdentifiableDao<T> getDao();

    protected abstract T getEntity();

    protected abstract List<T> getEntities();
}
