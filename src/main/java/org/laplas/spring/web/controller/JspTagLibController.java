package org.laplas.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Simple controller to verify workings of Spring Security jsp-tag library.
 *
 * @author Valentine Shemyako
 * @since January 14, 2019
 */
@Controller
@RequestMapping("/auth")
public class JspTagLibController {

    @GetMapping(value = "/secured")
    public String secured() {
        return "secured";
    }

    @GetMapping(value = "/unsecured")
    public String unsecured() {
        return "secured";
    }
}
