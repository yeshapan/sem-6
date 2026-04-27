/*
Objective:
Write a program to fetch and display database, table, and column metadata using
DatabaseMetaData and ResultSetMetaData.
 */

package com.yesha;
import java.sql.*;

public class P212_DatabaseAndResultSetMetadata {
    public static void main(String[] args) {
        // set up database connection variables
        final String url = "jdbc:mysql://localhost:3306/StudentDB";
        final String user = "root";
        final String password = "Yesha22";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Database metadata:");

            // fetch database metadata
            DatabaseMetaData dbMeta = conn.getMetaData();
            // print out specific database details
            System.out.println("database product name: " + dbMeta.getDatabaseProductName());
            System.out.println("database product version: " + dbMeta.getDatabaseProductVersion());
            System.out.println("jdbc driver name: " + dbMeta.getDriverName());
            System.out.println("jdbc driver version: " + dbMeta.getDriverVersion());

            System.out.println("\nResultset metadata:");

            // execute a query to get resultset metadata
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM Student")) {

                // fetch metadata from the returned resultset
                ResultSetMetaData rsMeta = rs.getMetaData();
                int columnCount = rsMeta.getColumnCount();
                System.out.println("total columns in student table: " + columnCount);

                // loop through columns to print metadata for each
                for (int i = 1; i <= columnCount; i++) {
                    System.out.println("column name: " + rsMeta.getColumnName(i));
                    System.out.println("data type: " + rsMeta.getColumnTypeName(i));
                    System.out.println("column size: " + rsMeta.getPrecision(i));
                }
            }

        } catch (SQLException e) {
            // handle sql errors
            e.printStackTrace();
        }
    }
}