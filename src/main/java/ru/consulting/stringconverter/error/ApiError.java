package ru.consulting.stringconverter.error;

import org.springframework.http.HttpStatus;

/**
 * The enum Api error.
 */
public enum ApiError {
    /**
     * The Line is null.
     */
    LINE_IS_NULL("Field 'line' is required and cannot be null.", HttpStatus.BAD_REQUEST);

    private final String message;
    private final HttpStatus httpStatus;

    ApiError(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    /**
     * To exception api exception.
     *
     * @return the api exception
     */
    public ApiException toException() {
        return new ApiException(message, httpStatus, name());
    }

}
