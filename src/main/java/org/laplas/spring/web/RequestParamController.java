package org.laplas.spring.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * The sole purpose of this controller is to test workings of {@link RequestParam} annotation.
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
@Controller
@RequestMapping(value = "/homepage")
public class RequestParamController {

    @GetMapping("/mood")
    public String mood(@RequestParam String mood) {
        return mood;
    }

    /**
     * In case no request-param name is explicitly specified all params
     * will be put into request-param map.
     */
    @GetMapping("/moods")
    @ResponseBody
    public List<String> moods(@RequestParam Map<String, String> moods) {
        return new ArrayList<>(moods.values());
    }
}
