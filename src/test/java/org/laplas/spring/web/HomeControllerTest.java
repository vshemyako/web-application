package org.laplas.spring.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Verifies functionality of default home controller {@link HomeControllerTest}.
 *
 * @author Valentine Shemyako
 * @since January 14, 2019
 */
public class HomeControllerTest {

    private static final String API_HOMEPAGE = "/homepage";

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
    }

    /**
     * Verifies that predefined default home GET request indeed results into
     * home {@link View} being returned.
     */
    @Test
    public void shouldReturnHomeView() throws Exception {
        mockMvc.perform(get(API_HOMEPAGE))
                .andExpect(view().name("home"));
    }
}