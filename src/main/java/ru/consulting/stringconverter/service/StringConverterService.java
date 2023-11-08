package ru.consulting.stringconverter.service;

import ru.consulting.stringconverter.model.LineRequest;

import java.util.Map;


/**
 * The interface String converter service.
 */
public interface StringConverterService {
    /**
     * Convert map.
     *
     * @param line the line
     * @return the map
     */
    Map<Character, Long> convert(LineRequest line);
}
