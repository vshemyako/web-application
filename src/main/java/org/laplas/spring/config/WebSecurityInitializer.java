package org.laplas.spring.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * Registers {@link DelegatingFilterProxy} instance in a servlet-container's filter-chain.
 *
 * @author Valentine Shemyako
 * @since January 17, 2019
 */
public class WebSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}
