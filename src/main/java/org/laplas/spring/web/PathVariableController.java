package org.laplas.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * The sole purpose of this controller is to test workings of {@link PathVariable} annotation.
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
@Controller
@RequestMapping("/face")
public class PathVariableController {

    @GetMapping(value = "/expression/{expression}")
    @ResponseBody
    public String expression(@PathVariable(name = "expression") String expression) {
        return expression;
    }
}
