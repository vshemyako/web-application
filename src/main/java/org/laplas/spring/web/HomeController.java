package org.laplas.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Configures simple Spring Mvc Controller to test and learn Spring Mvc module.
 *
 * @author Valentine Shemyako
 * @since January 14, 2019
 */
@Controller
public class HomeController {

    /**
     * Handles http Get requests for default "/" path.
     *
     * @return default home view name.
     */
    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}
