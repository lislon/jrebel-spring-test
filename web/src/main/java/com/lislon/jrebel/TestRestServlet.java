package com.lislon.jrebel;

import com.lislon.App;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pascal
 */
public class TestRestServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("GET method called");
        out.println("parameters:\n " + parameters(request));
        out.println("headers:\n " + headers(request));

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("POST method called");
        out.println("parameters: " + parameters(request));
        out.println("headers: " + headers(request));
    }

    public void doDelete(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Delete method called");
    }

    private String parameters(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        for (Enumeration e = request.getParameterNames(); e.hasMoreElements();) {
            String name = (String) e.nextElement();
            builder.append("|" + name + "->" + request.getParameter(name)+"\n");
        }
        return builder.toString();
    }

    private String headers(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        for (Enumeration e = request.getHeaderNames(); e.hasMoreElements();) {
            String name = (String) e.nextElement();
            builder.append("|" + name + "->" + request.getHeader(name)+"\n");
        }
        return builder.toString();
    }
}
