package ru.consulting.stringconverter.config;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.consulting.stringconverter.error.ApiException;
import ru.consulting.stringconverter.error.ErrorDTO;

/**
 * The type Global exception handler.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle api exception response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorDTO> handleApiException(ApiException ex) {
        return ResponseEntity.badRequest().body(
                new ErrorDTO(ex.getMessage(), ex.getCode(), ex.getHttpStatus())
        );
    }
}
