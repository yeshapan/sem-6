/*
Objective:
MVC-based Web Application : Design a small MVC-based application where Servlet
acts as controller, JSP acts as view, and database operations are handled using JDBC.
 */

package com.yesha;

public class P311_StudentModel {
    private String name;
    private double cgpa;

    // initializes model data
    public P311_StudentModel(String name, double cgpa) {
        this.name = name;
        this.cgpa = cgpa;
    }

    // gets student name
    public String getName() { return name; }

    // gets student cgpa
    public double getCgpa() { return cgpa; }
}

//see output at http://localhost:8080/mvc after running P311_MVCView.jsp