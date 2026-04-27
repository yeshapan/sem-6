/*
Objective:
Create database StudentDB and table Student(student_id, name, program, semester, cgpa)
using the JDBC Statement interface.
 */

package com.yesha;
import java.sql.*;

public class P202_CreateDBAndTable {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        // we'll need both a Connection and a Statement.
        // A Statement is like a delivery vehicle that carries our SQL queries to the database
        try (Connection conn = DriverManager.getConnection(url, "root", "Yesha22");
             Statement stmt = conn.createStatement()) {

            // executeUpdate() is used for DDL (CREATE, DROP, ALTER) and DML (INSERT, UPDATE, DELETE).
            // it returns a number, not database rows.
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS StudentDB");
            System.out.println("Database 'StudentDB' created.");

            // execute() runs a general command. Here, we tell MySQL to switch to our new database.
            stmt.execute("USE StudentDB");

            // write SQL query as a Java String.
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Student (" +
                    "student_id INT PRIMARY KEY, " +
                    "name VARCHAR(100), " +
                    "program VARCHAR(50), " +
                    "semester INT, " +
                    "cgpa DOUBLE)";

            // sending the CREATE TABLE query to MySQL
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'Student' created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}