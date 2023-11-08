package ru.consulting.stringconverter.error;

import lombok.Data;
import org.springframework.http.HttpStatus;


/**
 * The type Api exception.
 */
@Data
public class ApiException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String code;

    /**
     * Instantiates a new Api exception.
     *
     * @param message    the message
     * @param httpStatus the http status
     * @param code       the code
     */
    public ApiException(String message, HttpStatus httpStatus, String code) {
        super(message);
        this.httpStatus = httpStatus;
        this.code = code;
    }
}
