package pl.ap.service.impl;

import org.springframework.transaction.annotation.Transactional;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.domain.common.IdentifiableEntity;
import pl.ap.service.IIdentifiableService;
import pl.ap.service.util.SidUtils;

/**
 * Created by parado on 2014-10-15.
 */

public abstract class IdentifiableServiceImpl<T extends IdentifiableEntity> extends AbstractServiceImpl<T> implements IIdentifiableService<T> {

    protected abstract IIdentifiableDao<T> getDao();

    @Override
    public T save(T obj) {
        if (obj.getSid() == null) {
            obj.setSid(SidUtils.generate());
        }
        return super.save(obj);
    }

    @Transactional(readOnly = true)
    public T getBySid(String sid) {
        return getDao().getBySid(sid);
    }
}
