/*
Objective:
Create a basic servlet and deploy it on the server.
Study and explain the structure and purpose of the web.xml deployment
descriptor file.
 */

package com.yesha;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class P301_BasicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // set response content type
        response.setContentType("text/html");

        // get print writer object
        PrintWriter out = response.getWriter();

        // generate html output
        out.println("<html><body>");
        out.println("<h2>basic servlet runs successfully</h2>");
        out.println("</body></html>");
    }
}

// open output at http://localhost:8080/basic