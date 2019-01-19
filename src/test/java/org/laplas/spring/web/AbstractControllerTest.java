package org.laplas.spring.web;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Base class for controller's integration tests.
 *
 * @author Valentine Shemyako
 * Created on 16.01.2019.
 */
public abstract class AbstractControllerTest {

    protected MockMvc mockMvc;

    protected void setUpWithNoResolver(Object... controllers) {
        setUp(null, controllers);
    }

    protected void setUpWithJspResolver(Object... controllers) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setExposeContextBeansAsAttributes(true);

        setUp(viewResolver, controllers);
    }

    private void setUp(InternalResourceViewResolver viewResolver, Object[] controllers) {
        StandaloneMockMvcBuilder mockMvcBuilder = MockMvcBuilders.standaloneSetup(controllers)
                .setValidator(new LocalValidatorFactoryBean());
        if (viewResolver != null) {
            mockMvcBuilder.setViewResolvers(viewResolver);
        }
        mockMvc = mockMvcBuilder.build();
    }
}
