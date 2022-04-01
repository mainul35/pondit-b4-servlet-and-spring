package com.pondit.b4;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.sendRedirect("/hello-2");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var firstName = req.getParameter("firstName");
        var lastName = req.getParameter("lastName");
        System.out.println("Full name = " + firstName + " " + lastName);
        var servletContext = getServletContext();
        servletContext.setAttribute("fullName", firstName + " " + lastName);
        resp.setContentType("text/html");
        req.getRequestDispatcher("/hello.jsp")
                .forward(req, resp);
    }
}
