package pl.ap.dao.impl;

import org.springframework.stereotype.Repository;
import pl.ap.dao.IPassDao;
import pl.ap.domain.Pass;

/**
 * Created by parado on 2015-01-14.
 */
@Repository(PassDaoImpl.BEAN_NAME)
public class PassDaoImpl extends IdentifiableDaoImpl<Pass> implements IPassDao {

    public static final String BEAN_NAME = "passDao";
}
