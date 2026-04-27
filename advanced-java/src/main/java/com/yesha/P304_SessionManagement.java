/*
Objective:
Session Management Techniques : Create a login form and implement state
management using Cookies, HttpSession, and URL Rewriting.
*/

package com.yesha;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class P304_SessionManagement extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // set response type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // get username from request
        String username = request.getParameter("username");

        // manages state using httpsession
        HttpSession session = request.getSession();
        session.setAttribute("user", username);

        // manage state using cookies
        Cookie userCookie = new Cookie("userCookie", username);
        // set cookie expiration to one hour
        userCookie.setMaxAge(3600);
        // add cookie to response
        response.addCookie(userCookie);

        // manage state using url rewriting
        String url = response.encodeURL("WelcomeServlet");

        // print html output
        out.println("<html><body>");
        out.println("<h3>login completes</h3>");
        out.println("<p>session stores user: " + session.getAttribute("user") + "</p>");
        out.println("<p>cookie attaches to response.</p>");
        out.println("<a href='" + url + "'>clicks here for url rewriting demo</a>");
        out.println("</body></html>");
    }
}

// output at http://localhost:8080/P304_Login.html