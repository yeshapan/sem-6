/*
Objective:
Create a second table (e.g., Program) and fetch combined student information using
JOIN queries through JDBC.
 */
package com.yesha;
import java.sql.*;

public class P214_JoinQueries {
    public static void main(String[] args) {
        // define credentials
        final String url = "jdbc:mysql://localhost:3306/StudentDB";
        final String user = "root";
        final String password = "Yesha22";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            System.out.println("Join queries practical");

            // drop program table if it exists to avoid errors on rerun
            stmt.executeUpdate("DROP TABLE IF EXISTS Program");

            // create a new program table
            String createTableSql = "CREATE TABLE Program (" +
                    "program_code VARCHAR(10) PRIMARY KEY, " +
                    "department VARCHAR(50), " +
                    "duration_years INT)";
            stmt.executeUpdate(createTableSql);
            System.out.println("program table created");

            // insert reference data into program table
            stmt.executeUpdate("INSERT INTO Program VALUES ('BTech', 'Engineering', 4)");
            stmt.executeUpdate("INSERT INTO Program VALUES ('BCA', 'Computer Applications', 3)");
            stmt.executeUpdate("INSERT INTO Program VALUES ('MSc', 'Sciences', 2)");

            // ensure there is at least one student matching the program code
            stmt.executeUpdate("INSERT IGNORE INTO Student (student_id, name, program, semester, cgpa) VALUES (1401, 'Eve Join', 'BTech', 2, 8.4)");

            // execute a join query between student and program tables
            String joinQuery = "SELECT s.student_id, s.name, s.program, p.department, p.duration_years " +
                    "FROM Student s JOIN Program p ON s.program = p.program_code";

            try (ResultSet rs = stmt.executeQuery(joinQuery)) {
                System.out.println("Combined student and program information:");
                // iterate through the joined resultset
                while (rs.next()) {
                    int id = rs.getInt("student_id");
                    String name = rs.getString("name");
                    String prog = rs.getString("program");
                    String dept = rs.getString("department");
                    int duration = rs.getInt("duration_years");

                    // display the joined records
                    System.out.printf("id: %d | name: %s | program: %s | dept: %s | duration: %d yrs%n",
                            id, name, prog, dept, duration);
                }
            }

        } catch (SQLException e) {
            // catch sql exceptions
            e.printStackTrace();
        }
    }
}