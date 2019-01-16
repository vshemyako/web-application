package org.laplas.spring.web.model;

import javax.validation.constraints.Size;

/**
 * Simple model object to verify bean validation logic for handler methods.
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
public class Message {

    @Size(min = 3)
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
