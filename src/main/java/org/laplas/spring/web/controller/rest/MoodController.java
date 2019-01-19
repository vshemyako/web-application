package org.laplas.spring.web.controller.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.laplas.spring.web.model.Mood;
import org.laplas.spring.web.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/withHandler/{type}", method = RequestMethod.GET)
    public Mood typeWithExceptionHandling(@PathVariable String type) {
        Mood mood = moodService.getByType(type);
        assertMoodNotNull(mood, type);
        return mood;
    }

    private void assertMoodNotNull(Mood mood, String type) {
        if (mood == null) {
            throw new MoodNotFoundException(type);
        }
    }

    /**
     * Exception handler to process 'sad-path' logic.
     */
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = MoodNotFoundException.class)
    public Error moodNotFound(MoodNotFoundException ex) {
        return new Error(String.format("Mood wasn't found by type '%s'", ex.getType()));
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Error {
        private String message;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class MoodNotFoundException extends RuntimeException {
        private String type;
    }
}
