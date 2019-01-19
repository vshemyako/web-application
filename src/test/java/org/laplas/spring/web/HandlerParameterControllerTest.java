package org.laplas.spring.web;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Collections;
import java.util.Map;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.laplas.spring.web.controller.HandlerParameterController;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Verifies handler method parameter type binding functionality offered by Spring Mvc framework.
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
@RunWith(JUnitParamsRunner.class)
public class HandlerParameterControllerTest extends AbstractControllerTest {

    private static final String API_WEB_REQUEST = "/parameter/webrequest";
    private static final String API_SERVLET_REQUEST = "/parameter/servletrequest";
    private static final String API_ERROR = "/parameter/error";

    private static final Object[] getRequestMessages() {
        return new Object[]{
                new Object[]{"yo", "error"},
                new Object[]{"hello", "hello"}
        };
    }

    @Before
    public void setUp() {
        setUpWithJspResolver(new HandlerParameterController());
    }

    @Test
    public void shouldResolveWebRequestType() throws Exception {
        MultiValueMap<String, String> params = createParamMap(Collections.singletonMap("webrequest", "generic"));
        MvcResult mvcResult = performGetRequest(API_WEB_REQUEST, params);
        String response = mvcResult.getResponse().getContentAsString();
        assertEquals("generic", response);
    }

    @Test
    public void shouldResolveServletRequestType() throws Exception {
        MultiValueMap<String, String> params = createParamMap(Collections.singletonMap("servletrequest", "native"));
        MvcResult mvcResult = performGetRequest(API_SERVLET_REQUEST, params);
        String response = mvcResult.getResponse().getContentAsString();
        assertEquals("native", response);
    }

    @Test
    @Parameters(method = "getRequestMessages")
    public void shouldValidateMessage(String request, String expectedResponse) throws Exception {
        MvcResult mvcResult = mockMvc.perform(get(API_ERROR)
                .param("text", request))
                .andReturn();

        String actualResponse = mvcResult.getResponse().getContentAsString();
        assertEquals(expectedResponse, actualResponse);
    }

    private MultiValueMap<String, String> createParamMap(Map<String, String> params) {
        MultiValueMap<String, String> linkedParams = new LinkedMultiValueMap<>();
        params.forEach(linkedParams::add);
        return linkedParams;
    }

    private MvcResult performGetRequest(String api, MultiValueMap<String, String> params) throws Exception {
        return mockMvc.perform(get(api)
                .params(params))
                .andReturn();
    }
}