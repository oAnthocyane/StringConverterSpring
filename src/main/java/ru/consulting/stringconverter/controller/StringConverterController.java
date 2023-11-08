package ru.consulting.stringconverter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.consulting.stringconverter.model.LineRequest;
import ru.consulting.stringconverter.service.StringConverterService;

import java.util.Map;

/**
 * The type String converter controller.
 */
@RestController
@RequestMapping("/string/convert")
public class StringConverterController {
    private final StringConverterService stringConverterService;

    /**
     * Instantiates a new String converter controller.
     *
     * @param stringConverterService the string converter service
     */
    @Autowired
    public StringConverterController(StringConverterService stringConverterService) {
        this.stringConverterService = stringConverterService;
    }

    /**
     * String convert map.
     *
     * @param line the line
     * @return the map
     */
    @PostMapping
    public Map<Character, Long> stringConvert(@RequestBody LineRequest line) {
        return stringConverterService.convert(line);
    }

}
