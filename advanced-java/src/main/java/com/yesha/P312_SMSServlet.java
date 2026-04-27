/*
Objective:
Student Management System using Servlet and JSP : Develop a mini web application
to perform Insert, Update, Delete, and Display operations for student records using
Servlets, JSP, and JDBC.
 */

package com.yesha;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class P312_SMSServlet extends HttpServlet {
    private final String url = "jdbc:mysql://localhost:3306/StudentDB";
    private final String user = "root";
    private final String pass = "Yesha22";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> records = new ArrayList<>();

        // fetches all students for display
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, pass);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT student_id, name FROM Student")) {

                // populates list with records
                while (rs.next()) {
                    records.add(rs.getInt("student_id") + " - " + rs.getString("name"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // attaches list to request
        request.setAttribute("studentList", records);

        // forwards to dashboard
        request.getRequestDispatcher("P312_Dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // extracts form action type
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("student_id"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, pass)) {

                // executes delete logic
                if ("delete".equals(action)) {
                    PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Student WHERE student_id = ?");
                    pstmt.setInt(1, id);
                    pstmt.executeUpdate();
                }
                // executes insert logic
                else if ("insert".equals(action)) {
                    String name = request.getParameter("name");
                    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Student (student_id, name, program, semester, cgpa) VALUES (?, ?, 'BTech', 1, 8.0)");
                    pstmt.setInt(1, id);
                    pstmt.setString(2, name);
                    pstmt.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // redirects back to get method to refresh table
        response.sendRedirect("sms");
    }
}

// find output at http://localhost:8080/sms after running P312_Dashboard.jsp script