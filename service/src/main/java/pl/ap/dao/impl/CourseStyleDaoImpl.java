package pl.ap.dao.impl;

import pl.ap.dao.ICourseStyleDao;
import pl.ap.domain.CourseStyle;
import org.springframework.stereotype.Repository;

/**
 * Created by parado on 19.03.14.
 */
@Repository(CourseStyleDaoImpl.BEAN_NAME)
public class CourseStyleDaoImpl extends AbstractDaoImpl<CourseStyle> implements ICourseStyleDao
{
   public static final String BEAN_NAME = "courseStyleDao";
}
