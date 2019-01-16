package org.laplas.spring.web;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Base class for controller's integration tests.
 *
 * @author Valentine Shemyako
 *         Created on 16.01.2019.
 */
public abstract class AbstractControllerTest {

    protected MockMvc mockMvc;

    protected void setUp(Object... controllers) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setExposeContextBeansAsAttributes(true);

        mockMvc = MockMvcBuilders.standaloneSetup(controllers)
                .setViewResolvers(viewResolver)
                .setValidator(new LocalValidatorFactoryBean())
                .build();
    }
}
