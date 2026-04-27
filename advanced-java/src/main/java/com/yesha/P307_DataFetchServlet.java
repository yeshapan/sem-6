/*
Servlet–JSP Data Communication : Write a servlet that retrieves data from the
database and forwards the result to a JSP page using RequestDispatcher for display.
*/

package com.yesha;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class P307_DataFetchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // defines database variables
        String url = "jdbc:mysql://localhost:3306/StudentDB";
        String user = "root";
        String password = "Yesha22";
        List<String> studentNames = new ArrayList<>();

        // connects to database and fetches data
        try {
            // loads driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT name FROM Student")) {

                // iterates through resultset
                while (rs.next()) {
                    // adds name to list
                    studentNames.add(rs.getString("name"));
                }
            }
        } catch (Exception e) {
            // handles exception
            e.printStackTrace();
        }

        // sets data in request attribute
        request.setAttribute("students", studentNames);

        // forwards request to jsp using request dispatcher
        RequestDispatcher dispatcher = request.getRequestDispatcher("P307_Display.jsp");
        dispatcher.forward(request, response);
    }
}