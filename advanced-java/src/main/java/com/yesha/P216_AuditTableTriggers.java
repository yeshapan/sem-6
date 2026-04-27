/*
Objective:
Maintain an audit table that records insert, update, and delete operations using database
triggers accessed via JDBC.
*/

package com.yesha;
import java.sql.*;

public class P216_AuditTableTriggers {
    public static void main(String[] args) {
        // set up database connection strings
        final String url = "jdbc:mysql://localhost:3306/StudentDB";
        final String user = "root";
        final String password = "Yesha22";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            System.out.println("Audit table and triggers practical");

            // clean up old tables and triggers to ensure a fresh run
            stmt.executeUpdate("DROP TRIGGER IF EXISTS after_student_insert");
            stmt.executeUpdate("DROP TRIGGER IF EXISTS after_student_delete");
            stmt.executeUpdate("DROP TABLE IF EXISTS StudentAudit");

            // create the audit table to store historical actions
            String createAuditTable = "CREATE TABLE StudentAudit (" +
                    "audit_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "student_id INT, " +
                    "action VARCHAR(50), " +
                    "action_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
            stmt.executeUpdate(createAuditTable);
            System.out.println("student audit table created.");

            // create a trigger for insertions
            String createInsertTrigger = "CREATE TRIGGER after_student_insert " +
                    "AFTER INSERT ON Student FOR EACH ROW " +
                    "INSERT INTO StudentAudit (student_id, action) VALUES (NEW.student_id, 'INSERT')";
            stmt.executeUpdate(createInsertTrigger);

            // create a trigger for deletions
            String createDeleteTrigger = "CREATE TRIGGER after_student_delete " +
                    "AFTER DELETE ON Student FOR EACH ROW " +
                    "INSERT INTO StudentAudit (student_id, action) VALUES (OLD.student_id, 'DELETE')";
            stmt.executeUpdate(createDeleteTrigger);
            System.out.println("database triggers created successfully.");

            // insert a record to fire the insert trigger
            stmt.executeUpdate("INSERT INTO Student (student_id, name, program, semester, cgpa) VALUES (1601, 'Trigger Test', 'BTech', 6, 9.0)");

            // delete the same record to fire the delete trigger
            stmt.executeUpdate("DELETE FROM Student WHERE student_id = 1601");

            System.out.println("\nFetching audit logs:");

            // fetch the records from the audit table to prove triggers fired
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM StudentAudit")) {
                while (rs.next()) {
                    int auditId = rs.getInt("audit_id");
                    int studentId = rs.getInt("student_id");
                    String action = rs.getString("action");
                    Timestamp time = rs.getTimestamp("action_time");

                    // print the audit trail
                    System.out.printf("audit #%d | student_id: %d | action: %s | time: %s%n",
                            auditId, studentId, action, time.toString());
                }
            }

        } catch (SQLException e) {
            // log any sql errors
            e.printStackTrace();
        }
    }
}