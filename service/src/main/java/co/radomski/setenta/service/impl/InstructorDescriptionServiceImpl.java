package co.radomski.setenta.service.impl;

import co.radomski.setenta.dao.IAbstractDao;
import co.radomski.setenta.dao.IInstructorDescriptionDao;
import co.radomski.setenta.domain.Instructor;
import co.radomski.setenta.domain.InstructorDescription;
import co.radomski.setenta.service.IInstructorDescriptionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by parado on 19.03.14.
 */
@Service(InstructorDescriptionServiceImpl.BEAN_NAME)
public class InstructorDescriptionServiceImpl extends AbstractServiceImpl<InstructorDescription> implements
        IInstructorDescriptionService
{
   public static final String BEAN_NAME = "instructorDescriptionService";

   @Resource
   private IInstructorDescriptionDao instructorDescriptionDao;

   @Override
   protected IAbstractDao<InstructorDescription> getDao()
   {
      return instructorDescriptionDao;
   }

   @Override
   @Transactional(readOnly = true)
   public InstructorDescription getDescriptionByInstructor(Instructor instructor)
   {
      return instructorDescriptionDao.getBy(InstructorDescription.FIELD_INSTRUCTOR, instructor);
   }
}
