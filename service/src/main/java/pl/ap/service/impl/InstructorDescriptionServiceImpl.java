package pl.ap.service.impl;

import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IInstructorDescriptionDao;
import pl.ap.domain.Instructor;
import pl.ap.domain.InstructorDescription;
import pl.ap.service.IInstructorDescriptionService;
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
