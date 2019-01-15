package org.laplas.spring.web;

import org.junit.Test;

/**
 * Verifies functionality of a {@link HomeController} class using Selenium library.
 *
 * @author Valentine Shemyako
 * @since January 14, 2019
 */
public class HomeControllerFunctionalTest extends AbstractControllerFunctionalTest {

    private static final String BASE_URI = "localhost:8080/web-application";
    private static final String FUNNY_HOMEPAGE_URI_SUFFIX = "/homepage/funny";
    private static final String SERIOUS_HOMEPAGE_URI_SUFFIX = "/homepage/serious";

    /**
     * Verifies that Spring Mvc framework indeed intercepts http request and returns
     * expected page, contents of which are eventually checked.
     */
    @Test
    public void verifyFunnyHomeRequest() {
        chromeDriver.get(BASE_URI + FUNNY_HOMEPAGE_URI_SUFFIX);
        assertEqualPageTitle("Greeting Application");
        assertEqualElementTextContents("What's cookin', good lookin'?", "h3");
    }

    @Test
    public void verifySeriousHomeRequest() {
        chromeDriver.get(BASE_URI + SERIOUS_HOMEPAGE_URI_SUFFIX);
        assertEqualPageTitle("Greeting Application");
        assertEqualElementTextContents("Life is too short to be serious.", "h3");
    }
}
