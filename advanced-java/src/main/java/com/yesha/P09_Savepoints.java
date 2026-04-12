/*
Objective:
Implement transaction management using Savepoints, allowing partial rollback of
database operations.
 */

package com.yesha;
import java.sql.*;

public class P09_Savepoints {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/StudentDB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(url, "root", "Yesha22")) {

            // start transaction
            conn.setAutoCommit(false);
            Savepoint savepoint1 = null;

            try (Statement stmt = conn.createStatement()) {
                // insert Hank successfully
                stmt.executeUpdate("INSERT IGNORE INTO Student VALUES (301, 'Hank', 'Law', 1, 8.0)");
                System.out.println("Hank inserted.");

                // create a Savepoint (Bookmark) right after Hank is inserted.
                savepoint1 = conn.setSavepoint("Savepoint1");
                System.out.println("Savepoint created.");

                // insert Ivy successfully
                stmt.executeUpdate("INSERT IGNORE INTO Student VALUES (302, 'Ivy', 'Law', 1, 8.5)");
                System.out.println("Ivy inserted.");

                // intentionally throwing an error to simulate a server crash or bad data
                System.out.println("Simulating an unexpected failure...");
                if (true) throw new SQLException("Fake Server Crash!");

            } catch (SQLException e) {
                System.out.println("Error caught: " + e.getMessage());
                System.out.println("Rolling back to Savepoint 1...");

                // roll back ONLY to the savepoint!
                // this means Ivy is undone, but Hank is kept safe!
                conn.rollback(savepoint1);

                // commit the remaining safe data (Hank)
                conn.commit();
                System.out.println("Committed! Hank is in the database, but Ivy is not.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}