package pl.ap.service.impl;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.domain.common.IdentifiableEntity;
import pl.ap.domain.enums.ObjectStateEnum;
import pl.ap.exception.PropertyUpdateServiceException;
import pl.ap.service.IIdentifiableService;
import pl.ap.service.util.SidUtils;

import java.util.List;

/**
 * Created by parado on 2014-10-15.
 */

public abstract class IdentifiableServiceImpl<T extends IdentifiableEntity> extends AbstractServiceImpl<T> implements IIdentifiableService<T> {

    protected abstract IIdentifiableDao<T> getDao();

    @Override
    @Transactional(readOnly = false)
    public T save(T obj) {
        if (obj.getSid() == null) {
            obj.setSid(SidUtils.generate());
        }
        if (obj.getObjectState() == null) {
            obj.setObjectState(ObjectStateEnum.ACTIVE);
        }
        return super.save(obj);
    }

    @Transactional(readOnly = true)
    public T getBySid(String sid) {
        return getDao().getBySid(sid);
    }

    @Transactional(readOnly = false)
    public T activate(T obj) {
        obj.setObjectState(ObjectStateEnum.ACTIVE);
        return getDao().update(obj);
    }

    @Transactional(readOnly = false)
    public T deactivate(T obj) {
        obj.setObjectState(ObjectStateEnum.INACTIVE);
        return getDao().update(obj);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findBySids(List<String> sids) {
        return getDao().findBySids(sids);
    }

    @Override
    @Transactional
    public T update(T entity) {
        T oldInstance = getBySid(entity.getSid());
        assertEntityNotNull(oldInstance);
        updateFields(oldInstance, entity, getUpdateFields());
        return getDao().merge(oldInstance);
    }

    @Override
    @Transactional
    public T merge(T entity) {
        T oldInstance = getBySid(entity.getSid());
        assertEntityNotNull(oldInstance);
        updateFields(oldInstance, entity, getUpdateFields());
        return getDao().merge(oldInstance);
    }

    protected abstract String[] getUpdateFields();

    protected final void assertEntityNotNull(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity not found");
        }
    }

    protected void updateFields(Object previous, Object current, String... fields) {
        for (String field : fields) {
            updateField(previous, current, field);
        }
    }

    protected void updateField(Object previous, Object current, String field) {
        Object currentValue = getProperty(previous, field);
        Object nextValue = getProperty(current, field);
        if (hasChanged(currentValue, nextValue)) {
            setProperty(previous, field, nextValue);
        }
    }

    private void setProperty(Object bean, String name, Object value) {
        try {
            PropertyUtils.setProperty(bean, name, value);
        } catch (Exception e) {
            throw new PropertyUpdateServiceException(e.getMessage(), e);
        }
    }

    private Object getProperty(Object bean, String name) {
        try {
            return PropertyUtils.getProperty(bean, name);
        } catch (Exception e) {
            throw new PropertyUpdateServiceException(e.getMessage(), e);
        }
    }

    private boolean hasChanged(Object previousValue, Object currentValue) {
        if (previousValue == null && currentValue == null) {
            return false;
        }
        if (previousValue == null || currentValue == null) {
            return true;
        }
        return !previousValue.equals(currentValue);
    }
}
