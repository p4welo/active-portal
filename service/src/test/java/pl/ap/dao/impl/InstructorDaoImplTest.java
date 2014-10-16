package pl.ap.dao.impl;

import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.IInstructorDao;
import pl.ap.dao.TestDomainObjectFactory;
import pl.ap.domain.Instructor;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-16.
 */
public class InstructorDaoImplTest extends IdentifiableDaoImplTest<Instructor> {

    @Resource
    private IInstructorDao instructorDao;

    @Override
    protected IIdentifiableDao<Instructor> getDao() {
        return instructorDao;
    }

    @Override
    protected Instructor getEntity() {
        return TestDomainObjectFactory.getInstructor();
    }
}
