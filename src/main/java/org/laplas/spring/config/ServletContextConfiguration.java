package org.laplas.spring.config;

import org.laplas.spring.web.HomeController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Context configuration class, which applies to single front controller object.
 *
 * @author Valentine Shemyako
 * @since January 14, 2019
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = HomeController.class)
public class ServletContextConfiguration implements WebMvcConfigurer {

    /**
     * Resolve view names against .jsp files.
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setExposeContextBeansAsAttributes(true);
        registry.viewResolver(viewResolver);
    }

    /**
     * Enable access to static resources.
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
