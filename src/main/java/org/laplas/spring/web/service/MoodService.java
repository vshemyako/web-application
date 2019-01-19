package org.laplas.spring.web.service;

import org.laplas.spring.web.model.Mood;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Business layer of application which manages {@link Mood} instances.
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
@Service
public class MoodService {

    private final Map<String, Mood> nameToMood = new HashMap<>();

    {
        nameToMood.put("angry", new Mood("Angry"));
        nameToMood.put("sad", new Mood("Sad"));
        nameToMood.put("loving", new Mood("Loving"));
    }

    public List<Mood> getPositive() {
        return Collections.singletonList(
                new Mood("Positive")
        );
    }

    public Mood getByType(String type) {
        return nameToMood.get(type);
    }
}
