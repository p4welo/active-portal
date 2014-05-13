package co.radomski.setenta.dao.impl;

import co.radomski.setenta.dao.IInstructorDao;
import co.radomski.setenta.domain.Instructor;
import org.springframework.stereotype.Repository;

/**
 * Created by parado on 19.03.14.
 */
@Repository(InstructorDaoImpl.BEAN_NAME)
public class InstructorDaoImpl extends AbstractDaoImpl<Instructor> implements IInstructorDao
{
   public static final String BEAN_NAME = "instructorDao";
}
