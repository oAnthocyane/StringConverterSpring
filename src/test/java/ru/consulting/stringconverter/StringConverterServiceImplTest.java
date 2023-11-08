package ru.consulting.stringconverter;

import org.junit.jupiter.api.Test;
import ru.consulting.stringconverter.error.ApiError;
import ru.consulting.stringconverter.error.ApiException;
import ru.consulting.stringconverter.model.LineRequest;
import ru.consulting.stringconverter.service.StringConverterService;
import ru.consulting.stringconverter.service.StringConverterServiceImpl;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type String converter service impl test.
 */
public class StringConverterServiceImplTest {
    private StringConverterService stringConverterService = new StringConverterServiceImpl();

    /**
     * Test convert.
     */
    @Test
    public void testConvert() {
        String input = "aaabbbbcccdde";
        LineRequest lineRequest = new LineRequest();
        lineRequest.setLine(input);
        Map<Character, Long> result = stringConverterService.convert(lineRequest);

        assertEquals(5, result.size());
        assertEquals(4L, result.get('b'));
        assertEquals(3L, result.get('a'));
        assertEquals(3L, result.get('c'));
        assertEquals(2L, result.get('d'));
        assertEquals(1L, result.get('e'));
    }

    /**
     * Test convert with empty string.
     */
    @Test
    public void testConvertWithEmptyString() {
        String input = "";
        LineRequest lineRequest = new LineRequest();
        lineRequest.setLine(input);
        Map<Character, Long> result = stringConverterService.convert(lineRequest);

        assertTrue(result.isEmpty());
    }

    /**
     * Test convert with null line.
     */
    @Test
    public void testConvertWithNullLine() {
        StringConverterService stringConverterService = new StringConverterServiceImpl();
        try {
            stringConverterService.convert(new LineRequest());
            fail("Expected ApiError.LINE_IS_NULL exception but it was not thrown.");
        }catch (ApiException ignored) {}


    }
}
