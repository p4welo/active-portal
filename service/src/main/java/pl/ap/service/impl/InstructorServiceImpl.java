package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.dao.ICourseDao;
import pl.ap.dao.ICourseInstructorRelationDao;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.IInstructorDao;
import pl.ap.domain.Course;
import pl.ap.domain.Instructor;
import pl.ap.service.IInstructorService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 19.03.14.
 */
@Service(InstructorServiceImpl.BEAN_NAME)
public class InstructorServiceImpl extends IdentifiableServiceImpl<Instructor> implements IInstructorService {
    public static final String BEAN_NAME = "instructorService";

    @Resource
    private IInstructorDao instructorDao;

    @Resource
    private ICourseInstructorRelationDao courseInstructorRelationDao;

    @Override
    protected IIdentifiableDao<Instructor> getDao() {
        return instructorDao;
    }

    @Override
    protected String[] getUpdateFields() {
        return new String[] {
                Instructor.FIELD_OBJECT_STATE,
                Instructor.FIELD_FIRST_NAME,
                Instructor.FIELD_LAST_NAME,
                Instructor.FIELD_NICK
        };
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findCourses(Instructor instructor) {
        return courseInstructorRelationDao.findActiveCoursesByInstructor(instructor);
    }
}
