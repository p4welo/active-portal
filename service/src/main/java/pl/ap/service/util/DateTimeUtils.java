package pl.ap.service.util;

import org.joda.time.LocalTime;

/**
 * Created by parado on 21.03.14.
 */
public class DateTimeUtils {
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";

    public static LocalTime getTime(int hour, int minute) {
        return new LocalTime().withHourOfDay(hour).withMinuteOfHour(minute).withSecondOfMinute(0).withMillisOfSecond(0);
    }
}
