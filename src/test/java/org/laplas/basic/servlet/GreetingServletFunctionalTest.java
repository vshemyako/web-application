package org.laplas.basic.servlet;

import org.junit.Test;
import org.laplas.spring.web.AbstractControllerFunctionalTest;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

/**
 * Verifies functionality of a {@link GreetingServlet} class using Selenium library.
 *
 * @author Valentine Shemyako
 * @since January 14, 2019
 */
public class GreetingServletFunctionalTest extends AbstractControllerFunctionalTest {

    @Test
    public void greet() {
        chromeDriver.get("localhost:8080/web-application");
        chromeDriver.findElement(By.id("greet-text-input")).sendKeys("Selenium");
        chromeDriver.findElement(By.id("greet-button")).click();

        assertEquals("Hello Page", chromeDriver.getTitle());
        assertEquals("Hello, Selenium!", chromeDriver.findElement(By.tagName("h2")).getText());
    }
}
