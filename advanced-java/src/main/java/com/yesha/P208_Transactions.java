/*
Objective:
Perform multiple database operations using manual transaction control and demonstrate
commit and rollback mechanisms.
 */

package com.yesha;
import java.sql.*;

public class P208_Transactions {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/StudentDB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        // declare the connection outside the try block so we can access it in the catch block to rollback.
        try (Connection conn = DriverManager.getConnection(url, "root", "Yesha22")) {

            // start manual transaction block
            conn.setAutoCommit(false);

            try (Statement stmt = conn.createStatement()) {
                System.out.println("Attempting to insert Amren...");
                stmt.executeUpdate("INSERT INTO Student VALUES (201, 'Amren', 'Arts', 1, 6.0)");
                System.out.println("Amren inserted in memory (not committed yet).");

                System.out.println("Attempting to insert Emerie with the SAME ID...");
                // simulating an error! student_id is a Primary Key, so ID 201 already exists from Amren.
                // this will crash and throw an SQLException.
                stmt.executeUpdate("INSERT INTO Student VALUES (201, 'Emerie', 'Arts', 1, 7.0)");

                // this line will never be reached because of the crash above.
                conn.commit();
                System.out.println("Transaction committed successfully.");

            } catch (SQLException e) {
                // the catch block intercepts the crash!
                System.out.println("\nERROR DETECTED: " + e.getMessage());
                System.out.println("Initiating Rollback...");

                // UNDO! This removes Amren from the database
                conn.rollback();
                System.out.println("Transaction rolled back! Amren was NOT saved to the database.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}