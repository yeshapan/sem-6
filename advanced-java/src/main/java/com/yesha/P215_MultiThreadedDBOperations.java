/*
Objective:
Develop a multi-threaded Java program where multiple threads perform concurrent
database operations safely.
 */
package com.yesha;
import java.sql.*;

public class P215_MultiThreadedDBOperations {

    // configure connection variables
    private static final String URL = "jdbc:mysql://localhost:3306/StudentDB";
    private static final String USER = "root";
    private static final String PASSWORD = "Yesha22";

    public static void main(String[] args) {
        System.out.println("Multi-threaded database operations:");

        // create multiple threads to simulate concurrent operations
        Thread thread1 = new Thread(new DatabaseTask(1501, "Thread Student 1"));
        Thread thread2 = new Thread(new DatabaseTask(1502, "Thread Student 2"));
        Thread thread3 = new Thread(new DatabaseTask(1503, "Thread Student 3"));

        // start the threads
        thread1.start();
        thread2.start();
        thread3.start();

        // wait for all threads to finish execution
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            System.out.println("all database threads have finished executing.");
        } catch (InterruptedException e) {
            // handle thread interruption
            e.printStackTrace();
        }
    }

    // define a runnable class for thread operations
    static class DatabaseTask implements Runnable {
        private int studentId;
        private String studentName;

        // constructor to initialize thread-specific data
        public DatabaseTask(int studentId, String studentName) {
            this.studentId = studentId;
            this.studentName = studentName;
        }

        @Override
        public void run() {
            // each thread gets its own independent database connection
            String insertSQL = "INSERT INTO Student (student_id, name, program, semester, cgpa) VALUES (?, ?, 'BTech', 1, 7.5) ON DUPLICATE KEY UPDATE name = VALUES(name)";

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

                // set query parameters
                pstmt.setInt(1, studentId);
                pstmt.setString(2, studentName);

                // execute the insert
                pstmt.executeUpdate();

                // log thread success
                System.out.println(Thread.currentThread().getName() + " inserted/updated student id: " + studentId);

            } catch (SQLException e) {
                // catch sql exceptions inside the thread
                System.err.println(Thread.currentThread().getName() + " encountered an error:");
                e.printStackTrace();
            }
        }
    }
}