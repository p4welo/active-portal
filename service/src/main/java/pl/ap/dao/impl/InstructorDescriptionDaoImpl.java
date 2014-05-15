package pl.ap.dao.impl;

import pl.ap.dao.IInstructorDescriptionDao;
import pl.ap.domain.InstructorDescription;
import org.springframework.stereotype.Repository;

/**
 * Created by parado on 19.03.14.
 */
@Repository(InstructorDescriptionDaoImpl.BEAN_NAME)
public class InstructorDescriptionDaoImpl extends AbstractDaoImpl<InstructorDescription> implements
        IInstructorDescriptionDao
{
   public static final String BEAN_NAME = "instructorDescriptionDao";
}
