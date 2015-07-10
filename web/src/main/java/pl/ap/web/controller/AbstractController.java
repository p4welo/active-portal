package pl.ap.web.controller;

import pl.ap.domain.common.IdentifiableEntity;
import pl.ap.web.exceptions.InvalidParameterException;
import pl.ap.web.exceptions.NullParameterException;
import pl.ap.web.exceptions.SidNotFoundException;

/**
 * Created by parado on 2015-05-13.
 */
public abstract class AbstractController {

    protected static void assertNotNull(Object o, String field) {
        if (o == null) {
            throw new NullParameterException(field);
        }
    }

    protected static void assertSidObject(Object o) {
        if (o == null) {
            throw new SidNotFoundException();
        }
    }

    protected static void assertSidIntegrity(IdentifiableEntity o, String sid) {
        if (!sid.equals(o.getSid())) {
            throw new InvalidParameterException("sid");
        }
    }
}
