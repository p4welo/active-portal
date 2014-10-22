package pl.ap.service;

import pl.ap.domain.Instructor;
import pl.ap.domain.InstructorDescription;

/**
 * Created by parado on 19.03.14.
 */
public interface IInstructorDescriptionService extends IIdentifiableService<InstructorDescription> {
    InstructorDescription getDescriptionByInstructor(Instructor instructor);
}
