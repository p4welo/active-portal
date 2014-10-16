package pl.ap.domain.annotations;

import pl.ap.domain.validation.UniqueConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(
        {
                ElementType.TYPE
        })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueConstraintValidator.class)
@Documented
public @interface Unique {
    String message() default "{constraints.unique}";

    String[] fields();

    boolean insensitive() default true;

    Class<?>[] groups() default
            {};

    Class<? extends Payload>[] payload() default
            {};

    /**
     * <code>List</code> is used for handling multiple {@link Unique} constraints
     *
     * @author lukasz.kusy@solsoft.pl
     * @version $Revision: $ by $Author: lukasz
     * @since Sprint-8
     */
    @Target(
            {
                    ElementType.TYPE
            })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        Unique[] value();
    }
}
