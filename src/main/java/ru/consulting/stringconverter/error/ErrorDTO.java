package ru.consulting.stringconverter.error;

import org.springframework.http.HttpStatus;

/**
 * The type Error dto.
 */
public record ErrorDTO(
        String message, String code, HttpStatus httpStatus
) {
}
