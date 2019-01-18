package org.laplas.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Configures simple Spring Mvc Controller to test {@link RequestMapping} functionality, more
 * specifically how HTTP methods hierarchy is resolved when applied both at a class and a method level.
 *
 * @author Valentine Shemyako
 * @since January 14, 2019
 */
@Controller
@RequestMapping(value = "/greeting/clashing", method = RequestMethod.GET)
public class ClashingMappingController {

    /**
     * Intentionally put {@link RequestMethod#POST} at a method level which do not match
     * to class-level method, to verify that class-level method attribute takes precedence.
     * Update: actually method-level {@link RequestMapping} overrides class-level behavior
     * - there's a mistake in {@link RequestMapping} java-docs.
     */
    @RequestMapping(value = "funny", method = RequestMethod.POST)
    public String funny() {
        return "funny";
    }
}
