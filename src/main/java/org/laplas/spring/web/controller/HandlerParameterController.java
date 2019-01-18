package org.laplas.spring.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.validation.Valid;
import org.laplas.spring.web.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 * Configures simple Spring Mvc Controller to test and learn different handler parameter types.
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
@Controller
@RequestMapping(value = "/parameter")
public class HandlerParameterController {

    @GetMapping(value = "/webrequest")
    @ResponseBody
    public String webRequest(WebRequest webRequest) {
        String parameterName = "webrequest";
        String parameter = webRequest.getParameter(parameterName);
        Assert.notNull(parameter, String.format("No request parameter found by name '%s'", parameterName));
        return parameter;
    }

    @GetMapping(value = "/servletrequest")
    public void servletRequest(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        String parameterName = "servletrequest";
        String parameter = servletRequest.getParameter(parameterName);
        Assert.notNull(parameter, String.format("No request parameter found by name '%s'", parameterName));

        try (PrintWriter writer = new PrintWriter(servletResponse.getOutputStream())) {
            writer.write(parameter);
        }
    }

    @GetMapping(value = "/error")
    @ResponseBody
    public String errors(@Valid Message message, BindingResult bindingResult) {
        return bindingResult.hasErrors() ? "error" : message.getText();
    }
}
