/*
Objective:
Configure JDBC environment, load MySQL driver, and establish database connection to
verify successful connectivity.
 */

//package shows address of where the current file rests in project directory
package com.yesha;

//import the entire java.sql library (which contains all the JDBC classes we need)
import java.sql.*;

public class P201_VerifyConnection {
    public static void main(String[] args) {

        // Connection String (URL).
        // we use the base URL (localhost:3306/) because we haven't created a specific database yet.
        String url = "jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        // Try-with-resources block.
        // by putting the Connection inside the parenthesis (), Java will automatically close
        // the database connection when the program finishes, preventing memory leaks!
        try (Connection conn = DriverManager.getConnection(url, "root", "Yesha22")) {

            // if the code reaches this line, it means the connection did not throw an error.
            System.out.println("Practical 1: JDBC Environment Configured and Connected successfully!");

        } catch (SQLException e) {
            // if the password is wrong or MySQL is off, it catches the error and prints it here.
            e.printStackTrace();
        }
    }
}