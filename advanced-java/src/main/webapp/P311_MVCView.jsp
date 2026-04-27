<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.yesha.P311_StudentModel" %>
<html>
<body>
    <h2>mvc view: student details</h2>
    <%
        // retrieves the model from the request
        P311_StudentModel student = (P311_StudentModel) request.getAttribute("studentData");

        // prints model data
        if (student != null) {
            out.println("<p>name: " + student.getName() + "</p>");
            out.println("<p>cgpa: " + student.getCgpa() + "</p>");
        }
    %>
</body>
</html>