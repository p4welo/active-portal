package pl.ap.domain.validation;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import pl.ap.domain.annotations.Unique;
import pl.ap.domain.common.DataEntity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public class UniqueConstraintValidator implements ConstraintValidator<Unique, DataEntity> {
    private static ISessionProvider sessionProvider;

    private String[] fields;

    private boolean insensitive;

    @Override
    public void initialize(Unique annotation) {
        this.fields = annotation.fields();
        this.insensitive = annotation.insensitive();
    }

    @Override
    public boolean isValid(DataEntity entity, ConstraintValidatorContext context) {
        try {
            DataEntity dataObject = getDataObject(entity);
            return dataObject == null || dataObject.getId().equals(entity.getId());
        } catch (Exception e) {
            throw new RuntimeException("unable to validate entity", e);
        }
    }

    private DataEntity getDataObject(DataEntity entity) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException {
        Session session = sessionProvider.getCurrentSession();
        Criteria criteria = session.createCriteria(entity.getClass());
        criteria.setFlushMode(FlushMode.COMMIT);
        for (String field : fields) {
            Object value = PropertyUtils.getProperty(entity, field);
            if (value == null) {
                criteria.add(Restrictions.isNull(field));
            } else {
                SimpleExpression eq = Restrictions.eq(field, value);
                PropertyDescriptor propertyDescriptor = PropertyUtils.getPropertyDescriptor(entity, field);
                if (String.class.equals(propertyDescriptor.getPropertyType()) && insensitive) {
                    eq = eq.ignoreCase();
                }
                criteria.add(eq);
            }
        }
        DataEntity dataObject = (DataEntity) criteria.uniqueResult();
        return dataObject;
    }

    public static void setSessionProvider(ISessionProvider sessionProvider) {
        UniqueConstraintValidator.sessionProvider = sessionProvider;
    }
}