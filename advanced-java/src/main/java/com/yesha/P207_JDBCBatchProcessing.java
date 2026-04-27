/*
Objective:
Insert multiple student records in a single execution using JDBC batch processing to
improve performance.
 */

package com.yesha;
import java.sql.*;

public class P207_JDBCBatchProcessing {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/StudentDB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        // standard insert query with placeholders
        String sql = "INSERT IGNORE INTO Student (student_id, name, program, semester, cgpa) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, "root", "Yesha22");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // CRITICAL: Turn off Auto-Commit.
            /* Java executes and saves every query immediately by default.
             We turn this off so we can group them together in a batch. */
            conn.setAutoCommit(false);

            // create an array of data to simulate inserting multiple students
            Object[][] students = {
                    {101, "Nesta", "Warfare", 2, 9.1},
                    {102, "Elain", "Botany", 2, 8.2},
                    {103, "Feyre", "Biology", 3, 8.5}
            };

            // loop through the array
            for (Object[] student : students) {
                pstmt.setInt(1, (int) student[0]);
                pstmt.setString(2, (String) student[1]);
                pstmt.setString(3, (String) student[2]);
                pstmt.setInt(4, (int) student[3]);
                pstmt.setDouble(5, (double) student[4]);

                // use addBatch() instead of executeUpdate()
                // this adds the query to a "shopping cart" but doesn't check out yet.
                pstmt.addBatch();
            }

            // execute everything in the batch at once
            int[] results = pstmt.executeBatch();

            // commit to permanently save the changes to the database
            conn.commit();

            System.out.println("Batch executed successfully! Processed " + results.length + " queries in a single trip.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}