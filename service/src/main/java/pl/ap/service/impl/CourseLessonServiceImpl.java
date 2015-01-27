package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.ICourseLessonDao;
import pl.ap.domain.CourseLesson;
import pl.ap.service.ICourseLessonService;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-16.
 */
@Service
public class CourseLessonServiceImpl extends AbstractServiceImpl<CourseLesson> implements ICourseLessonService {
    public static final String BEAN_NAME = "courseLessonService";

    @Resource
    private ICourseLessonDao courseLessonDao;

    @Override
    protected IAbstractDao<CourseLesson> getDao() {
        return courseLessonDao;
    }
}
