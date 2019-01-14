package org.laplas.basic.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Plain framework-less java servlet to verify workings of gradle's build-in servlet container.
 *
 * @author Valentine Shemyako
 * @since January 13, 2019
 */
@WebServlet(name = "GreetingServlet", urlPatterns = "greet", loadOnStartup = 1)
public class GreetingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("Hello, dear Friend!");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if (name == null || name.length() == 0) {
            name = "Stranger";
        }
        request.setAttribute("user", name);
        request.getRequestDispatcher("greeting_response.jsp").forward(request, response);
    }
}
