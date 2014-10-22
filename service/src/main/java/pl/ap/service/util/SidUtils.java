package pl.ap.service.util;

import java.util.UUID;

/**
 * User: pawel.radomski
 * Date: 12.04.13
 * Time: 15:03
 */
public class SidUtils {
    public static final String generate() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
