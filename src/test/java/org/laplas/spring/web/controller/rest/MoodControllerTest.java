package org.laplas.spring.web.controller.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.laplas.spring.web.AbstractControllerTest;
import org.laplas.spring.web.service.MoodService;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Verifies that rest-controller indeed writes output directly to the request-body,
 * omitting view-resolution phase.
 *
 * @author Valentine Shemyako
 * @since January 19, 2019
 */
@RunWith(MockitoJUnitRunner.class)
public class MoodControllerTest extends AbstractControllerTest {

    private static final String API_MOOD_POSITIVE = "/rest/mood/positive";
    private static final String API_MOOD_TYPE = "/rest/mood/{type}";
    private static final String API_MOOD_TYPE_WITH_STATUS = "/rest/mood/withStatus/{type}";

    private MoodService moodService = new MoodService();

    @Before
    public void setUp() {
        setUpWithNoResolver(new MoodController(moodService));
    }

    /**
     * Verifies that {@link MediaType#APPLICATION_JSON} results in json {@link HttpMessageConverter}
     * being applied for converting web-controller's result.
     */
    @Test
    public void shouldReturnJson() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get(API_MOOD_POSITIVE).accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String expectedJsonResponse = "[{\"name\":\"Positive\"}]";
        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        assertEquals(expectedJsonResponse, actualJsonResponse);
        assertNull(mvcResult.getModelAndView());
    }

    /**
     * Verifies that {@link MediaType#APPLICATION_XML} results in XML {@link HttpMessageConverter}
     * being applied for converting web-controller's result.
     */
    @Test
    public void shouldReturnXml() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get(API_MOOD_POSITIVE).accept(MediaType.APPLICATION_XML))
                .andReturn();

        String expectedXmlResponse = "<List><item><name>Positive</name></item></List>";
        String actualXmlResponse = mvcResult.getResponse().getContentAsString();
        assertEquals(expectedXmlResponse, actualXmlResponse);
        assertNull(mvcResult.getModelAndView());
    }

    /**
     * Verifies that without additional status handling mechanisms
     * web-controller always return ok-status response code no matter what.
     */
    @Test
    public void shouldReturnOkStatus() throws Exception {
        mockMvc.perform(get(API_MOOD_TYPE, "angry"))
                .andExpect(status().isOk());

        mockMvc.perform(get(API_MOOD_TYPE, "cherry"))
                .andExpect(status().isOk());
    }

    /**
     * Verifies functionality of {@link ResponseEntity} class which allows
     * to additionally specify http status code.
     */
    @Test
    public void shouldReturnStatusDependingOnResult() throws Exception {
        mockMvc.perform(get(API_MOOD_TYPE_WITH_STATUS, "angry"))
                .andExpect(status().isOk());

        mockMvc.perform(get(API_MOOD_TYPE_WITH_STATUS, "cherry"))
                .andExpect(status().is(404));
    }
}