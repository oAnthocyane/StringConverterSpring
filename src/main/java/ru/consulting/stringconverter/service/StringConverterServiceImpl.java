package ru.consulting.stringconverter.service;

import org.springframework.stereotype.Service;
import ru.consulting.stringconverter.error.ApiError;
import ru.consulting.stringconverter.model.LineRequest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type String converter service.
 */
@Service
public class StringConverterServiceImpl implements StringConverterService {
    @Override
    public Map<Character, Long> convert(LineRequest lineRequest) {
        String line = lineRequest.getLine();
        if (line == null) throw ApiError.LINE_IS_NULL.toException();
        return countAllSymbols(line).entrySet().stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


    }

    private Map<Character, Long> countAllSymbols(String line) {
        Map<Character, Long> symbolCountMap = new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            symbolCountMap.put(symbol, symbolCountMap.getOrDefault(symbol, 0L) + 1L);
        }
        return symbolCountMap;
    }

}
