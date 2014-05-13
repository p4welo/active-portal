package co.radomski.setenta.service;

import co.radomski.setenta.domain.Instructor;
import co.radomski.setenta.domain.InstructorDescription;

/**
 * Created by parado on 19.03.14.
 */
public interface IInstructorDescriptionService extends IAbstractService<InstructorDescription>
{
   InstructorDescription getDescriptionByInstructor(Instructor instructor);
}
