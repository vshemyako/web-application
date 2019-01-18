package org.laplas.spring.web.service;

import java.util.Arrays;
import java.util.List;
import org.laplas.spring.web.model.Mood;
import org.springframework.stereotype.Service;

/**
 * Business layer of application which manages {@link Mood} instances.
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
@Service
public class MoodService {

    public List<Mood> getPositive() {
        return Arrays.asList(
                new Mood("Amused"),
                new Mood("Dreamy"),
                new Mood("Joyful")
        );
    }
}
