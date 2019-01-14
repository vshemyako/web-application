package org.laplas.spring.web;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

/**
 * Verifies functionality of a {@link HomeController} class using Selenium library.
 *
 * @author Valentine Shemyako
 * @since January 14, 2019
 */
public class HomeControllerFunctionalTest extends AbstractControllerFunctionalTest {

    /**
     * Verifies that Spring Mvc framework indeed intercepts http request and returns
     * expected page, contents of which are eventually checked.
     */
    @Test
    public void verifyHomeRequest() {
        chromeDriver.get("localhost:8080/web-application/homepage");

        String actualPageTitle = chromeDriver.getTitle();
        assertEquals("Greeting Application", actualPageTitle);
        String actualHeaderMessage = chromeDriver.findElement(By.tagName("h3")).getText();
        assertEquals("Welcome to the Home Page", actualHeaderMessage);
    }
}
