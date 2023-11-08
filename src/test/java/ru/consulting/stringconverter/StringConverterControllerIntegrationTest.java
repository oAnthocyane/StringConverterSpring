package ru.consulting.stringconverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

/**
 * The type String converter controller integration test.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class StringConverterControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Sets .
     */
    @BeforeEach
    public void setup() {
    }

    /**
     * Test string convert api.
     *
     * @throws Exception the exception
     */
    @Test
    public void testStringConvertAPI() throws Exception {
        String input = "aaabbbbcccdde";
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(Map.of("line", input));
        String expectedResponse = """
                {
                    "b": 4,
                    "a": 3,
                    "c": 3,
                    "d": 2,
                    "e": 1
                }""";

        mockMvc.perform(MockMvcRequestBuilders.post("/string/convert")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedResponse));
    }

    /**
     * Test string convert api with empty string.
     *
     * @throws Exception the exception
     */
    @Test
    public void testStringConvertAPIWithEmptyString() throws Exception {
        String input = "";
        String expectedResponse = "{}";
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(Map.of("line", input));

        mockMvc.perform(MockMvcRequestBuilders.post("/string/convert")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedResponse));
    }

    /**
     * Test convert with null line.
     *
     * @throws Exception the exception
     */
    @Test
    public void testConvertWithNullLine() throws Exception {
        String input = "";
        String expectedResponse = """
                {
                    "message": "Field 'line' is required and cannot be null.",
                    "code": "LINE_IS_NULL",
                    "httpStatus": "BAD_REQUEST"
                }""";

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(Map.of("not_line", input));

        mockMvc.perform(MockMvcRequestBuilders.post("/string/convert")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json(expectedResponse));
    }

    }

