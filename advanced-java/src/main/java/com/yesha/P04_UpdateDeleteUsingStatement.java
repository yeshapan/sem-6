/*
Objective:
Update student details such as CGPA or semester and delete records based on student ID
using Statement.
 */
package com.yesha;
import java.sql.*;

public class P04_UpdateDeleteUsingStatement {
    public static void main(String[] args) {

        // point directly to our created StudentDB
        String url = "jdbc:mysql://localhost:3306/StudentDB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        // set up the Connection and Statement inside the try-with-resources block
        try (Connection conn = DriverManager.getConnection(url, "root", "Yesha22");
             Statement stmt = conn.createStatement()) {

            // write update query
            System.out.println("\n Executing UPDATE");
            String updateSQL = "UPDATE Student SET name = 'Tasha', program='Aerospace Engg', cgpa = 9.9, semester = 5 WHERE student_id = 1";

            // executeUpdate() is used for UPDATE queries
            // it returns an integer representing exactly how many rows were changed in the database
            int rowsUpdated = stmt.executeUpdate(updateSQL);
            System.out.println("Success! " + rowsUpdated + " record(s) updated.");

            System.out.println("\n Executing DELETE");
            // write delete query
            String deleteSQL = "DELETE FROM Student WHERE student_id = 2";

            // executeUpdate() is used for DELETE queries as well
            int rowsDeleted = stmt.executeUpdate(deleteSQL);
            System.out.println("Success! " + rowsDeleted + " record(s) deleted.");

        } catch (SQLException e) {
            // prints the error trace if something foes wrong
            e.printStackTrace();
        }
    }
}