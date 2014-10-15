package pl.ap.domain;

/**
 * Created by parado on 2014-09-30.
 */
public class Password {
    private User user;

    private String value;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
