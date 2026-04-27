/*
Objective:
Authentication Filter : Implement an authentication mechanism using Servlet Filter
API that allows access to protected resources only after successful login.
 */

package com.yesha;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class P305_AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // initialize filter
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // cast request and response to http types
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // get existing session without creating a new one
        HttpSession session = req.getSession(false);

        // check if user logs in
        boolean isLoggedIn = (session != null && session.getAttribute("user") != null);

        // allow access or redirects to login
        if (isLoggedIn) {
            // pass request along the filter chain
            chain.doFilter(request, response);
        } else {
            // redirect unauthorized user to login page
            res.sendRedirect("login.html");
        }
    }

    @Override
    public void destroy() {
        // destroy filter instances
    }
}