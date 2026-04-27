/*
Objective:
Store and retrieve student images or textual data in the database using BLOB or CLOB
data types.
 */

/*
CLOB stands for Character Large Object.
It is used to store massive amounts of text (like essays, books, or huge descriptions)
that are too big for standard VARCHAR columns.
 */

package com.yesha;
import java.sql.*;

public class P210_ClobData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/StudentDB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(url, "root", "Yesha22");
             Statement stmt = conn.createStatement()) {

            System.out.println("\n 1. Setting up the Table");
            // alter our Student table to add a TEXT column.
            // in MySQL, TEXT is the standard equivalent to a CLOB.
            try {
                stmt.execute("ALTER TABLE Student ADD COLUMN profile_summary TEXT");
                System.out.println("Added 'profile_summary' column to Student table.");
            } catch (SQLException ignored) {
                // if the column already exists from a previous run, ignore the error
            }

            System.out.println("\n 2. Storing CLOB Data ");
            String updateSQL = "UPDATE Student SET profile_summary = ? WHERE student_id = 101";

            try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
                // create the massive block of text.
                String longText = "Tasha is an incredibly dedicated student. She has spent the last " +
                        "three years researching quantum mechanics and building micro-satellites. " +
                        "This text could realistically be millions of characters long!";

                // using JDBC to convert the String into a formal CLOB object
                Clob clobData = conn.createClob();
                clobData.setString(1, longText);

                // save the CLOB into the prepared statement
                pstmt.setClob(1, clobData);
                pstmt.executeUpdate();
                System.out.println("CLOB data successfully saved to database for Student 101.");
            }

            System.out.println("\n 3. Retrieving CLOB Data ");
            // let's prove it worked by fetching it back out!
            ResultSet rs = stmt.executeQuery("SELECT name, profile_summary FROM Student WHERE student_id = 101");

            if (rs.next()) {
                // retrieve the data as a Clob object
                Clob retrievedClob = rs.getClob("profile_summary");

                // convert the Clob back to a readable Java String (starting at character 1, length of clob)
                String text = retrievedClob.getSubString(1, (int) retrievedClob.length());

                System.out.println("Student Name: " + rs.getString("name"));
                System.out.println("Profile Summary: " + text);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}