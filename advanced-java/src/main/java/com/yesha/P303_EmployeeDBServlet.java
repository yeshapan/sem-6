/*
Objective:
Servlet with Database Integration : Design an HTML form to input employee details
and submit the data to a servlet. The servlet should insert the submitted data into a
database table Employee(EmpId, EName, Email, Age) using JDBC.
 */
package com.yesha;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class P303_EmployeeDBServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // extract form parameters
        int empId = Integer.parseInt(request.getParameter("empId"));
        String eName = request.getParameter("eName");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));

        // define database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDB";
        String user = "root";
        String password = "Yesha22";

        // define insert query
        String query = "INSERT INTO Employee (EmpId, EName, Email, Age) VALUES (?, ?, ?, ?)";

        // connect to database and executes query
        try {
            // load jdbc driver explicitly for web environment
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

                // set query parameters
                pstmt.setInt(1, empId);
                pstmt.setString(2, eName);
                pstmt.setString(3, email);
                pstmt.setInt(4, age);

                // executes update
                int rows = pstmt.executeUpdate();

                // prints success message
                if (rows > 0) {
                    out.println("<h3>employee record inserts successfully!</h3>");
                }
            }
        } catch (Exception e) {
            // prints error message
            out.println("<h3>error occurs: " + e.getMessage() + "</h3>");
        }
    }
}

// open output at http://localhost:8080/P303_Input.html (submit input to servlet)