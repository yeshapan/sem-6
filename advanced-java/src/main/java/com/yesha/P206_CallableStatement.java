/*
Objective:
Create a stored procedure for inserting or retrieving student records and invoke it using
JDBC CallableStatement
*/

package com.yesha;
import java.sql.*;

public class P206_CallableStatement {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/StudentDB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(url, "root", "Yesha22");
             Statement stmt = conn.createStatement()) {

            System.out.println("\n1. Creating the Stored Procedure:");
            // first drop the procedure if it already exists so we don't get an error running this twice.
            stmt.execute("DROP PROCEDURE IF EXISTS GetStudentName");

            // write the Procedure
            // IN: data we send to the database (Student ID).
            // OUT: data the database sends back to us (Student Name).
            String createProc = "CREATE PROCEDURE GetStudentName(IN s_id INT, OUT s_name VARCHAR(100)) " +
                    "BEGIN " +
                    "   SELECT name INTO s_name FROM Student WHERE student_id = s_id; " +
                    "END";

            // execute the creation of the procedure on the MySQL server
            stmt.execute(createProc);
            System.out.println("Stored Procedure 'GetStudentName' created successfully in MySQL.");

            System.out.println("\n 2. Calling the Stored Procedure: ");
            // we'll use CallableStatement instead of PreparedStatement to trigger procedures.
            // Syntax is: {call ProcedureName(?, ?)}
            try (CallableStatement cstmt = conn.prepareCall("{call GetStudentName(?, ?)}")) {

                // set the IN parameter (The first '?', which is student_id = 1)
                cstmt.setInt(1, 1);

                // register the OUT parameter (The second '?').
                // we need to tell Java what data type to expect back from the database.
                cstmt.registerOutParameter(2, Types.VARCHAR);

                // execute the call
                cstmt.execute();

                // fetch the result from the 2nd parameter
                String fetchedName = cstmt.getString(2);
                System.out.println("Success! Fetched name via Stored Procedure: " + fetchedName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}