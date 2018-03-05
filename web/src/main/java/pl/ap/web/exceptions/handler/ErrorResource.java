package pl.ap.web.exceptions.handler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by parado on 2015-05-13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResource {
    private String message;
    private String field;

    public ErrorResource(String message) {
        this.message = message;
    }

    public ErrorResource(String message, String field) {
        this.message = message;
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
