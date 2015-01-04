package pl.ap.publ.api;

/**
 * User: pawel.radomski
 * Date: 26.11.13
 * Time: 17:38
 */
public interface PublicApiMappings {
    public static final String COURSE_LIST = "/course/list";

    public static final String PRINT_COURSE_LIST = COURSE_LIST + "/print";

    public static final String REGISTRATION_COURSE_LIST = "/course/registration";

    public static final String NEWS_LIST = "/news/list";

    public static final String INSTRUCTOR_LIST = "/instructor/list";

    public static final String INSTRUCTOR_DESCRIPTION = "/instructor/{sid}/description";

    public static final String SEND_FEEDBACK = "/feedback/send";

    public static final String SEND_FEEDBACK_JSONP = "/feedback/{rate}/{type}/{description}/send";
}
