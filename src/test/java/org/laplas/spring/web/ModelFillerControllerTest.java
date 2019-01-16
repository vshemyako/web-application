package org.laplas.spring.web;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.laplas.spring.web.resolver.DummyViewResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
public class ModelFillerControllerTest {

    private static final String API_MODEL = "/model";

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ModelFillerController())
                .setViewResolvers(new DummyViewResolver())
                .build();
    }

    @Test
    public void shouldResolveView() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get(API_MODEL)
                .param("attribute", "flexibility"))
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        assertEquals("flexibility", response);
    }
}