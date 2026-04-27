/*
Objective:
Create a scrollable and updatable ResultSet and perform record navigation, insertion,
update, and deletion without using SQL DML queries.
 */
package com.yesha;
import java.sql.*;

public class P211_ScrollableUpdatableResultSet {
    public static void main(String[] args) {
        // define database connection constants
        final String url = "jdbc:mysql://localhost:3306/StudentDB";
        final String user = "root";
        final String password = "Yesha22";

        // establish connection and creating a scrollable, updatable statement
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery("SELECT student_id, name, program, semester, cgpa FROM Student")) {

            System.out.println("Scrollable and updatable resultset demo:");

            // navigate to the last record to test scrollability
            if (rs.last()) {
                System.out.println("last record: " + rs.getString("name") + " (ID: " + rs.getInt("student_id") + ")");
            }

            // navigate back to the first record
            if (rs.first()) {
                System.out.println("first record: " + rs.getString("name") + " (ID: " + rs.getInt("student_id") + ")");
            }

            // insert a new record directly through the resultset
            rs.moveToInsertRow();
            rs.updateInt("student_id", 1101);
            rs.updateString("name", "Alice Scrollable");
            rs.updateString("program", "BTech");
            rs.updateInt("semester", 3);
            rs.updateDouble("cgpa", 8.8);
            rs.insertRow();
            System.out.println("new record inserted via resultset.");

            // move back to the current row context after insertion
            rs.moveToCurrentRow();

            // navigate to find the record we just inserted (assuming it's added at the end)
            rs.last();
            // update the record's cgpa
            rs.updateDouble("cgpa", 9.2);
            rs.updateRow();
            System.out.println("record updated via resultset.");

            // delete the record via resultset to keep the database clean
            rs.deleteRow();
            System.out.println("record deleted via resultset.");

        } catch (SQLException e) {
            // print sql exception details
            e.printStackTrace();
        }
    }
}