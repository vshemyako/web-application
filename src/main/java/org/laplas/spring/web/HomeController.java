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
@RequestMapping(value = "/homepage")
public class HomeController {

    /**
     * Handles HTTP GET requests for "/homepage/funny" path.
     *
     * @return default funny view name.
     */
    @RequestMapping(value = "/funny", method = RequestMethod.GET)
    public String funny() {
        return "funny";
    }

    /**
     * Handles HTTP GET requests for "/homepage/serious" path.
     *
     * @return default serious view name.
     */
    @RequestMapping(value = "/serious", method = RequestMethod.GET)
    public String serious() {
        return "serious";
    }
}
