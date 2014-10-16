package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.ICourseUnitDao;
import pl.ap.domain.CourseUnit;
import pl.ap.service.ICourseUnitService;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-16.
 */
@Service
public class CourseUnitServiceImpl extends AbstractServiceImpl<CourseUnit> implements ICourseUnitService {
    public static final String BEAN_NAME = "courseUnitService";

    @Resource
    private ICourseUnitDao courseUnitDao;

    @Override
    protected IAbstractDao<CourseUnit> getDao() {
        return courseUnitDao;
    }
}
