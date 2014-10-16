package pl.ap.dao.impl;

import org.springframework.stereotype.Repository;
import pl.ap.dao.ICourseUnitDao;
import pl.ap.domain.CourseUnit;

/**
 * Created by parado on 2014-10-16.
 */
@Repository(CourseUnitDaoImpl.BEAN_NAME)
public class CourseUnitDaoImpl extends AbstractDaoImpl<CourseUnit> implements ICourseUnitDao {
    public static final String BEAN_NAME = "courseUnitDao";
}
