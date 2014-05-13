package co.radomski.setenta.service.impl;

import co.radomski.setenta.dao.IAbstractDao;
import co.radomski.setenta.dao.IInstructorDao;
import co.radomski.setenta.domain.Instructor;
import co.radomski.setenta.service.IInstructorService;
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
