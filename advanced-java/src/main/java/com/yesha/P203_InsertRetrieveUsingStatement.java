/*
Objective:
Insert multiple student records into the Student table and retrieve them using Statement
and ResultSet.
 */

package com.yesha;
import java.sql.*;

public class P203_InsertRetrieveUsingStatement {
    public static void main(String[] args) {

        // URL points specifically inside StudentDB
        String url = "jdbc:mysql://localhost:3306/StudentDB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(url, "root", "Yesha22");
             Statement stmt = conn.createStatement()) {

            // insert data using executeUpdate.
            // IGNORE prevents an error if we run this file twice and the ID already exists.
            stmt.executeUpdate("INSERT IGNORE INTO Student VALUES (1, 'Alice', 'Computer Science', 4, 8.5)");
            stmt.executeUpdate("INSERT IGNORE INTO Student VALUES (2, 'Bob', 'Information Tech', 4, 7.8)");
            System.out.println("Records inserted.");

            // executeQuery() is strictly for SELECT statements.
            // it returns a ResultSet (which is basically a table holding the data we asked for).
            ResultSet rs = stmt.executeQuery("SELECT * FROM Student");
            System.out.println("\nStudent Records:");

            // rs.next() moves the "cursor" down the table row by row.
            // it returns 'true' if there is a row, and 'false' when it reaches the end.
            while (rs.next()) {
                // extract the data from the current row by specifying the column name and data type.
                int id = rs.getInt("student_id");
                String name = rs.getString("name");
                double cgpa = rs.getDouble("cgpa");

                System.out.println("ID: " + id + ", Name: " + name + ", CGPA: " + cgpa);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}