package org.laplas.spring.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Verifies workings of {@link RequestParam} annotation.
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
@RunWith(JUnitParamsRunner.class)
public class RequestParamControllerTest extends AbstractControllerTest {

    private static final String API_MOOD = "/homepage/mood";
    private static final String API_MOODS = "/homepage/moods";

    private static final Object[] getMoods() {
        return new Object[]{
                new Object[]{"funny"},
                new Object[]{"serious"}
        };
    }

    @Before
    public void setUp() {
        setUp(new RequestParamController());
    }

    /**
     * Verifies that a request parameter is properly mapped to a method parameter.
     */
    @Test
    @Parameters(method = "getMoods")
    public void shouldReturnSpecifiedView(String mood) throws Exception {
        mockMvc.perform(get(API_MOOD)
                .param("mood", mood))
                .andExpect(MockMvcResultMatchers.view().name(mood));
    }

    /**
     * Verifies that multiple request parameters are bound to a {@link Map} type method parameter.
     */
    @Test
    public void shouldReturnAllMoods() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get(API_MOODS)
                .param("summer", "funny")
                .param("winter", "serious"))
                .andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        String[] actualMoods = new ObjectMapper().readValue(response, String[].class);
        String[] expectedMoods = new String[]{"funny", "serious"};
        Assert.assertArrayEquals(expectedMoods, actualMoods);
    }
}