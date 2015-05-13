package pl.ap.web.exceptions.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.ap.web.exceptions.InvalidParameterException;
import pl.ap.web.exceptions.NotFoundException;

/**
 * Created by parado on 2015-05-13.
 */
@ControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            NotFoundException.class
    })
    protected ResponseEntity<Object> handleNotFoundRequest(RuntimeException e, WebRequest request) {
        NotFoundException ex = (NotFoundException) e;
        ErrorResource error = new ErrorResource("404", ex.getMessage());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(e, error, headers, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({
            InvalidParameterException.class
    })
    protected ResponseEntity<Object> handleInvalidParameterException(RuntimeException e, WebRequest request) {
        InvalidParameterException ex = (InvalidParameterException) e;
        ErrorResource error = new ErrorResource(ex.getMessage(), ex.getField());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(e, error, headers, HttpStatus.NOT_ACCEPTABLE, request);
    }
}
