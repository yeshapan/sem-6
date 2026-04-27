<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head><title>Custom Error Page</title></head>
<body>
    <h2 style="color:red;">an application exception occurred!</h2>
    <hr>
    <p><strong>error type:</strong> <%= exception.getClass().getName() %></p>
    <p><strong>message:</strong> <%= exception.getMessage() %></p>
    <p><a href="P309_TriggerException.jsp">try again</a></p>
</body>
</html>