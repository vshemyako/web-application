package org.laplas.servlet;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

/**
 * Verifies functionality of a {@link GreetingServlet} class using Selenium library.
 *
 * @author Valentine Shemyako
 * @since January 14, 2019
 */
public class GreetingServletFunctionalTest {

    private ChromeDriver chromeDriver;

    @BeforeClass
    public static void setUpClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setUp() {
        chromeDriver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        chromeDriver.quit();
    }

    @Test
    public void greet() {
        chromeDriver.get("localhost:8080/web-application");
        chromeDriver.findElement(By.id("greet-text-input")).sendKeys("Selenium");
        chromeDriver.findElement(By.id("greet-button")).click();

        assertEquals("Hello Page", chromeDriver.getTitle());
        assertEquals("Hello, Selenium!", chromeDriver.findElement(By.tagName("h2")).getText());
    }
}
