package org.laplas.spring.web;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

/**
 * Base test class with common set-up and tear-down methods.
 *
 * @author Valentine Shemyako
 * @since January 14, 2019
 */
public abstract class AbstractControllerFunctionalTest {

    protected ChromeDriver chromeDriver;

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

    protected void assertEqualPageTitle(String expectedTitle) {
        assertEquals(expectedTitle, chromeDriver.getTitle());
    }

    protected void assertEqualElementTextContents(String expectedText, String tagName) {
        String actualText = chromeDriver.findElement(By.tagName(tagName)).getText();
        assertEquals(expectedText, actualText);
    }
}
