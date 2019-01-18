package org.laplas.spring.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.laplas.spring.web.controller.HomeController;
import org.springframework.web.servlet.View;

/**
 * Verifies functionality of default home controller {@link HomeControllerTest}.
 *
 * @author Valentine Shemyako
 * @since January 14, 2019
 */
public class HomeControllerTest extends AbstractControllerTest {

    private static final String API_FUNNY_HOMEPAGE = "/homepage/funny";
    private static final String API_SERIOUS_HOMEPAGE = "/homepage/serious";

    @Before
    public void setUp() {
        setUp(new HomeController());
    }

    /**
     * Verifies that predefined default funny home GET request indeed results into
     * funny {@link View} being returned.
     */
    @Test
    public void shouldReturnFunnyHomeView() throws Exception {
        mockMvc.perform(get(API_FUNNY_HOMEPAGE))
                .andExpect(view().name("funny"));
    }

    /**
     * Verifies that predefined default serious home GET request indeed results into
     * serious {@link View} being returned.
     */
    @Test
    public void shouldReturnSeriousHomeView() throws Exception {
        mockMvc.perform(get(API_SERIOUS_HOMEPAGE))
                .andExpect(view().name("serious"));
    }
}