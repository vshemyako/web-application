package org.laplas.basic.servlet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit-tests {@link GreetingServlet} class.
 *
 * @author Valentine Shemyako
 * @since January 14, 2019
 */
public class GreetingServletTest {

    private static final String HTTP_REQUEST_PARAM_NAME = "name";
    private static final String GREETING_RESPONSE_PAGE = "greeting_response.jsp";
    private static final String HTTP_REQUEST_PARAM_NAME_VALUE = "Servlet";
    private static final String GREETING_RESPONSE_PAGE_USER_ATTRIBUTE = "user";

    private @Mock HttpServletRequest httpRequest;
    private @Mock HttpServletResponse httpResponse;
    private @Mock RequestDispatcher requestDispatcher;
    private GreetingServlet greetingServlet;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        greetingServlet = new GreetingServlet();
    }

    /**
     * Verifies that GET http request results in default greeting string.
     */
    @Test
    public void shouldWriteDefaultGreetingMessageOnGetRequest() throws IOException {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(httpResponse.getWriter()).thenReturn(printWriter);

        greetingServlet.doGet(httpRequest, httpResponse);

        assertEquals("Hello, dear Friend!", stringWriter.toString());
    }

    /**
     * Verifies that POST http request results in default key-value pair being injected,
     * and request being forwarded further.
     */
    @Test
    public void shouldSetDefaultParameterOnPostRequest() throws ServletException, IOException {
        when(httpRequest.getParameter(HTTP_REQUEST_PARAM_NAME)).thenReturn(null);
        when(httpRequest.getRequestDispatcher(GREETING_RESPONSE_PAGE)).thenReturn(requestDispatcher);

        greetingServlet.doPost(httpRequest, httpResponse);

        verify(httpRequest).setAttribute(GREETING_RESPONSE_PAGE_USER_ATTRIBUTE, "Stranger");
        verify(requestDispatcher).forward(httpRequest, httpResponse);
    }

    /**
     * Verifies that POST http request results in specified attributes being set in request,
     * and request being forwarded further.
     */
    @Test
    public void shouldSetPredefinedParameterOnPostRequest() throws ServletException, IOException {
        when(httpRequest.getParameter(HTTP_REQUEST_PARAM_NAME)).thenReturn(HTTP_REQUEST_PARAM_NAME_VALUE);
        when(httpRequest.getRequestDispatcher(GREETING_RESPONSE_PAGE)).thenReturn(requestDispatcher);

        greetingServlet.doPost(httpRequest, httpResponse);

        verify(httpRequest).setAttribute(GREETING_RESPONSE_PAGE_USER_ATTRIBUTE, HTTP_REQUEST_PARAM_NAME_VALUE);
        verify(requestDispatcher).forward(httpRequest, httpResponse);
    }
}