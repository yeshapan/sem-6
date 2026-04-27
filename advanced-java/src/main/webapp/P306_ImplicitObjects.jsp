<%
    /*
    Objective:
    JSP Program using Implicit Objects : Write a JSP program to display details of the
    user currently accessing the system using JSP implicit objects.
    */
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>P306_ImplicitObjects</title>
</head>
<body>
    <h2>jsp implicit objects demonstration</h2>
    <%
        // prints details using out implicit object
        out.println("<p>remote client ip (uses request object): " + request.getRemoteAddr() + "</p>");
        out.println("<p>server name (uses request object): " + request.getServerName() + "</p>");

        // sets session attribute using session implicit object
        session.setAttribute("sessionID", session.getId());
        // prints session details
        out.println("<p>session id (uses session object): " + session.getAttribute("sessionID") + "</p>");

        // gets context info using application implicit object
        out.println("<p>server info (uses application object): " + application.getServerInfo() + "</p>");

        // check result at http://localhost:8080/P306_ImplicitObjects.jsp
    %>
</body>
</html>