package org.laplas.spring.config;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Java-based deployment descriptor. Configures single {@link DispatcherServlet} along with related contexts.
 *
 * @author Valentine Shemyako
 * @since January 14, 2019
 */
public class GreetingApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ServletContextConfiguration.class, SecurityConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
