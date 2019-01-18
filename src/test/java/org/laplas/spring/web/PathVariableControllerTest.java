package org.laplas.spring.web;

import static org.junit.Assert.assertEquals;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.laplas.spring.web.controller.PathVariableController;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Verifies workings of {@link PathVariable} annotation.
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
@RunWith(JUnitParamsRunner.class)
public class PathVariableControllerTest extends AbstractControllerTest {

    private static final String API_FACE_EXPRESSION = "/face/expression/{expression}";

    private static final Object[] getFaceExpressions() {
        return new Object[]{
                new Object[]{"funny"},
                new Object[]{"serious"},
        };
    }

    @Before
    public void setUp() {
        setUp(new PathVariableController());
    }

    /**
     * Verifies that URI template variable is properly resolved via
     * {@link PathVariable} annotation.
     */
    @Test
    @Parameters(method = "getFaceExpressions")
    public void shouldResolvePathVariable(String faceExpression) throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(API_FACE_EXPRESSION, faceExpression))
                .andReturn();
        String actualExpression = mvcResult.getResponse().getContentAsString();
        assertEquals(faceExpression, actualExpression);
    }
}