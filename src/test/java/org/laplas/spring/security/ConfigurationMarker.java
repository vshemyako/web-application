package org.laplas.spring.security;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * Marker class to be utilized by {@link ComponentScan} annotation or similar.
 * Additionally enables usage of all Spring Security supported method-level annotations.
 *
 * @author Valentine Shemyako
 * @since January 18, 2019
 */
@Configuration
@ComponentScan
@EnableGlobalMethodSecurity(jsr250Enabled = true, securedEnabled = true, prePostEnabled = true)
public class ConfigurationMarker extends GlobalMethodSecurityConfiguration {
}
