package org.laplas.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * The sole purpose of this controller is to test workings of {@link ModelAndView} type.
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
@Controller
@RequestMapping(value = "model")
public class ModelFillerController {

    @GetMapping
    public void fill(@RequestParam String attribute, Model model) {
        model.addAttribute("attribute", attribute);
    }
}
