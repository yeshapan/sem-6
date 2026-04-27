<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html>
<body>
    <h2>student management system</h2>

    <fieldset>
        <legend>add new student</legend>
        <form action="sms" method="POST">
            <input type="hidden" name="action" value="insert">
            id: <input type="number" name="student_id" required>
            name: <input type="text" name="name" required>
            <button type="submit">insert record</button>
        </form>
    </fieldset>

    <br>

    <h3>current students</h3>
    <ul>
        <%
            // retrieves list from servlet
            List<String> students = (List<String>) request.getAttribute("studentList");
            if (students != null) {
                // iterates over students
                for (String s : students) {
                    // parses id for deletion link
                    String id = s.split("-")[0].trim();
                    out.println("<li>" + s +
                        " <form action='sms' method='POST' style='display:inline;'>" +
                        "<input type='hidden' name='action' value='delete'>" +
                        "<input type='hidden' name='student_id' value='" + id + "'>" +
                        "<button type='submit'>delete</button></form></li>");
                }
            }
        %>
    </ul>
</body>
</html>