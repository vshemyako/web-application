package org.laplas.spring.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Verifies functionality of default home controller {@link HomeControllerTest}.
 *
 * @author Valentine Shemyako
 * @since January 14, 2019
 */
public class HomeControllerTest {

    private static final String API_FUNNY_HOMEPAGE = "/homepage/funny";
    private static final String API_SERIOUS_HOMEPAGE = "/homepage/serious";

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setExposeContextBeansAsAttributes(true);

        mockMvc = MockMvcBuilders.standaloneSetup(new HomeController())
                .setViewResolvers(viewResolver)
                .build();
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