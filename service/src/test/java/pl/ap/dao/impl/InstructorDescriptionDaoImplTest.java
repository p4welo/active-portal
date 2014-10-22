package pl.ap.dao.impl;

import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.IInstructorDescriptionDao;
import pl.ap.dao.TestDomainObjectFactory;
import pl.ap.domain.Instructor;
import pl.ap.domain.InstructorDescription;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-16.
 */
public class InstructorDescriptionDaoImplTest extends IdentifiableDaoImplTest<InstructorDescription> {
    @Resource
    private IInstructorDescriptionDao instructorDescriptionDao;

    @Override
    protected IIdentifiableDao<InstructorDescription> getDao() {
        return instructorDescriptionDao;
    }

    @Override
    protected InstructorDescription getEntity() {
        Instructor instructor = TestDomainObjectFactory.getInstructor();
        persist(instructor);
        return TestDomainObjectFactory.getInstructorDescription(instructor);
    }
}
