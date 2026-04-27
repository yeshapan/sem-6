/*
Objective:
Client Information Servlet : Write a servlet that displays the following client and server
details: Client browser information, client IP address, client port number, server port
number, local port number, HTTP method used by the client, and query string names and
values.
 */
package com.yesha;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class P302_ClientInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // set response content type
        response.setContentType("text/html");

        // get print writer object
        PrintWriter out = response.getWriter();

        // start html response
        out.println("<html><body>");
        out.println("<h2>client and server information</h2>");

        // display client browser info
        out.println("<p>browser: " + request.getHeader("User-Agent") + "</p>");

        // display ip and port details
        out.println("<p>client ip address: " + request.getRemoteAddr() + "</p>");
        out.println("<p>client port: " + request.getRemotePort() + "</p>");
        out.println("<p>server port: " + request.getServerPort() + "</p>");
        out.println("<p>local port: " + request.getLocalPort() + "</p>");

        // display http method
        out.println("<p>http method: " + request.getMethod() + "</p>");

        // retrieve and displays query string parameters
        out.println("<h3>query string parameters:</h3>");
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            // get parameter name
            String paramName = paramNames.nextElement();
            // get parameter value
            String paramValue = request.getParameter(paramName);
            // print parameter details
            out.println("<p>" + paramName + " = " + paramValue + "</p>");
        }

        // end html response
        out.println("</body></html>");
    }
}

// open http://localhost:8080/client-info to see output of this