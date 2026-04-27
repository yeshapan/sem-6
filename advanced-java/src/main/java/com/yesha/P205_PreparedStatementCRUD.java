/*
Objective:
Perform insert, select, update, and delete operations on the Student table using
PreparedStatement with user input.
 */
package com.yesha;
import java.sql.*;
import java.util.Scanner;

public class P205_PreparedStatementCRUD {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/StudentDB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        Scanner scanner = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(url, "root", "Yesha22")) {

            // get dynamic user input from the console
            System.out.print("Enter new Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); //consumes the leftover 'enter' key press

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            // write the SQL query (but put placeholders (?) where the data should go)
            String insertSQL = "INSERT INTO Student (student_id, name, program, semester, cgpa) VALUES (?, ?, 'AI', 1, 8.5)";

            // prepare the statement *before* executing it
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                // insert the user's data into the question marks
                // '1' means the first question mark, '2' means the second and so on
                pstmt.setInt(1, id);
                pstmt.setString(2, name);

                // run the query!
                pstmt.executeUpdate();
                System.out.println("Inserted successfully.");
            }

            // Search using PreparedStatement
            String selectSQL = "SELECT name, cgpa FROM Student WHERE student_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                pstmt.setInt(1, id); // Replace the '?' with the ID the user typed

                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) { // 'if' instead of 'while' because an ID is unique (only 1 result expected)
                    System.out.println("Found: " + rs.getString("name") + " with CGPA " + rs.getDouble("cgpa"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}