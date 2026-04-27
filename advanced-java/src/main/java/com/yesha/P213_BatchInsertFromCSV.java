/*
Objective:
Read student records from a text/CSV file and insert them into the database using batch
processing and transactions.
 */
package com.yesha;

import java.io.*;
import java.sql.*;

public class P213_BatchInsertFromCSV {
    public static void main(String[] args) {
        // database credentials
        final String url = "jdbc:mysql://localhost:3306/StudentDB";
        final String user = "root";
        final String password = "Yesha22";
        final String csvFilePath = "temp_students.csv";

        // create a dummy csv file programmatically for self-containment
        createDummyCSV(csvFilePath);

        String insertQuery = "INSERT INTO Student (student_id, name, program, semester, cgpa) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(insertQuery);
             BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {

            // turn off auto-commit to manage transactions manually
            conn.setAutoCommit(false);

            String line;
            // skip the header row of the csv
            br.readLine();

            // read the csv file line by line
            while ((line = br.readLine()) != null) {
                // split the comma-separated values
                String[] data = line.split(",");

                // set parameters for the prepared statement
                pstmt.setInt(1, Integer.parseInt(data[0].trim()));
                pstmt.setString(2, data[1].trim());
                pstmt.setString(3, data[2].trim());
                pstmt.setInt(4, Integer.parseInt(data[3].trim()));
                pstmt.setDouble(5, Double.parseDouble(data[4].trim()));

                // add the query to the batch
                pstmt.addBatch();
            }

            // execute the batch of inserts
            int[] updateCounts = pstmt.executeBatch();

            // commit the transaction to save changes
            conn.commit();
            System.out.println("successfully inserted " + updateCounts.length + " records from csv via batch processing.");

        } catch (SQLException | IOException e) {
            // print exception details
            e.printStackTrace();
        } finally {
            // clean up the temporary csv file
            new File(csvFilePath).delete();
        }
    }

    // helper method to generate a temporary csv file
    private static void createDummyCSV(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            // write the header
            writer.println("student_id,name,program,semester,cgpa");
            // write dummy records
            writer.println("1301,Feyre CSV,MSc,1,8.5");
            writer.println("1302,Nesta CSV,BTech,5,7.9");
            writer.println("1303,Elain CSV,BCA,3,9.1");
        } catch (IOException e) {
            // handle io exception
            e.printStackTrace();
        }
    }
}