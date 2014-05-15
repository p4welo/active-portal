package pl.ap.dao.impl;

import pl.ap.dao.IInstructorDao;
import pl.ap.domain.Instructor;
import org.springframework.stereotype.Repository;

/**
 * Created by parado on 19.03.14.
 */
@Repository(InstructorDaoImpl.BEAN_NAME)
public class InstructorDaoImpl extends AbstractDaoImpl<Instructor> implements IInstructorDao
{
   public static final String BEAN_NAME = "instructorDao";
}
