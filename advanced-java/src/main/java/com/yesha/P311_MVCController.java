package com.yesha;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class P311_MVCController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // creates default model
        P311_StudentModel student = new P311_StudentModel("Not Found", 0.0);

        String url = "jdbc:mysql://localhost:3306/StudentDB";
        String user = "root";
        String pass = "Yesha22";

        // fetches actual data from database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, pass);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT name, cgpa FROM Student LIMIT 1")) {

                // updates model if record exists
                if (rs.next()) {
                    student = new P311_StudentModel(rs.getString("name"), rs.getDouble("cgpa"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // passes model to the view
        request.setAttribute("studentData", student);

        // forwards request to jsp view
        RequestDispatcher dispatcher = request.getRequestDispatcher("P311_MVCView.jsp");
        dispatcher.forward(request, response);
    }
}