<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<html>
<head>
    <title>Employee Data</title>
    <style>
        table { border-collapse: collapse; width: 50%; }
        th, td { border: 1px solid black; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h2>employee records from database</h2>

    <%
        // retrieves the list of maps from the request attribute
        List<Map<String, String>> employees = (List<Map<String, String>>) request.getAttribute("empList");

        if (employees != null && !employees.isEmpty()) {
    %>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Age</th>
            </tr>
            <%
                // iterates through each employee map
                for (Map<String, String> emp : employees) {
            %>
                <tr>
                    <td><%= emp.get("id") %></td>
                    <td><%= emp.get("name") %></td>
                    <td><%= emp.get("email") %></td>
                    <td><%= emp.get("age") %></td>
                </tr>
            <%
                }
            %>
        </table>
    <%
        } else {
            out.println("<p>no records found in the database.</p>");
        }
    %>
</body>
</html>