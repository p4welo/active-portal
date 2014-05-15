package pl.ap.service.impl;

import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IInstructorDao;
import pl.ap.domain.Instructor;
import pl.ap.service.IInstructorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by parado on 19.03.14.
 */
@Service(InstructorServiceImpl.BEAN_NAME)
public class InstructorServiceImpl extends AbstractServiceImpl<Instructor> implements IInstructorService
{
   public static final String BEAN_NAME = "instructorService";

   @Resource
   private IInstructorDao instructorDao;

   @Override
   protected IAbstractDao<Instructor> getDao()
   {
      return instructorDao;
   }
}
