package org.laplas.spring.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.laplas.spring.web.controller.ClashingMappingController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Verifies functionality of controller {@link HomeControllerTest} with classing {@link RequestMapping} attributes.
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
public class ClashingMappingControllerTest extends AbstractControllerTest {

    private static final String API_CLASHING_FUNNY_GREETING = "/greeting/clashing/funny";

    @Before
    public void setUp() {
        setUp(new ClashingMappingController());
    }

    @Test
    public void shouldMatchClassLevelHttpMethod() throws Exception {
        mockMvc.perform(post(API_CLASHING_FUNNY_GREETING))
                .andExpect(view().name("funny"));
    }
}