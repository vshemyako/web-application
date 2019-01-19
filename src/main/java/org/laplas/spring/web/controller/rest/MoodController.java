package org.laplas.spring.web.controller.rest;

import org.laplas.spring.web.model.Mood;
import org.laplas.spring.web.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Simple controller class to test REST support provided by Spring Framework.
 *
 * @author Valentine Shemyako
 * @since January 14, 2019
 */
@RestController
@RequestMapping(value = "/rest/mood")
public class MoodController {

    private MoodService moodService;

    @Autowired
    public MoodController(MoodService moodService) {
        this.moodService = moodService;
    }

    @RequestMapping(value = "/positive", method = RequestMethod.GET)
    public List<Mood> positive() {
        return moodService.getPositive();
    }

    @RequestMapping(value = "/{type}", method = RequestMethod.GET)
    public Mood type(@PathVariable String type) {
        return moodService.getByType(type);
    }

    /**
     * In contrast with {@link #type(String)} method, this one supplies additional
     * status-code info along with request body.
     */
    @RequestMapping(value = "/withStatus/{type}", method = RequestMethod.GET)
    public ResponseEntity<Mood> typeWithStatus(@PathVariable String type) {
        Mood mood = moodService.getByType(type);
        return mood == null
                ? new ResponseEntity<>(mood, HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(mood, HttpStatus.OK);
    }
}
