package org.laplas.spring.web.controller.rest;

import java.util.List;
import org.laplas.spring.web.model.Mood;
import org.laplas.spring.web.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Simple controller class to test REST support provided by Spring Framework.
 *
 * @author Valentine Shemyako
 * @since January 14, 2019
 */
@Controller
@RequestMapping(value = "/rest/mood")
public class MoodController {

    private MoodService moodService;

    @Autowired
    public MoodController(MoodService moodService) {
        this.moodService = moodService;
    }

    @ResponseBody
    @RequestMapping(value = "/positive", method = RequestMethod.GET)
    public List<Mood> positive() {
        return moodService.getPositive();
    }
}
