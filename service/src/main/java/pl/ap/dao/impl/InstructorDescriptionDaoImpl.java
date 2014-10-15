package pl.ap.dao.impl;

import org.springframework.stereotype.Repository;
import pl.ap.dao.IInstructorDescriptionDao;
import pl.ap.domain.InstructorDescription;

/**
 * Created by parado on 19.03.14.
 */
@Repository(InstructorDescriptionDaoImpl.BEAN_NAME)
public class InstructorDescriptionDaoImpl extends IdentifiableDaoImpl<InstructorDescription> implements
        IInstructorDescriptionDao {
    public static final String BEAN_NAME = "instructorDescriptionDao";
}
