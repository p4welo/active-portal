package pl.ap.factory;

import pl.ap.service.util.SidUtils;

/**
 * Created by parado on 2014-10-20.
 */
public class CommonTestDomainObjectFactory {
    protected static String buildLongString(int length) {
        String sid = SidUtils.generate();
        if (sid.length() > length) {
            return sid.substring(0, length);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(i % 10);
        }
        return sb.toString();
    }
}
