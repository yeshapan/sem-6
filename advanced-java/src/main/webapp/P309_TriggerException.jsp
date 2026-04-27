<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="P309_ExceptionHandler.jsp" %>
<html>
<head><title>Trigger Error</title></head>
<body>
    <h2>calculates a division by zero</h2>
    <%
        // triggers an arithmetic exception automatically (division by zero)
        int result = 100 / 0;
        out.println("result is " + result);
    %>
    <h6>Output at http://localhost:8080/P309_TriggerException.jsp<h6>
</body>
</html>