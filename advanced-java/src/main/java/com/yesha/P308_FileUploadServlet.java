/*
File Upload using Servlet : Develop a servlet-based application that allows a user to
upload a file and store it on the server.
*/

package com.yesha;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

// configures servlet for multipart form data
@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5)
public class P308_FileUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // gets upload directory path
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);

        // creates directory if it does not exist
        if (!uploadDir.exists()) {
            // makes the directory
            uploadDir.mkdir();
        }

        // processes parts of the multipart request
        for (Part part : request.getParts()) {
            // gets file name
            String fileName = part.getSubmittedFileName();
            if (fileName != null && !fileName.isEmpty()) {
                // writes file to disk
                part.write(uploadPath + File.separator + fileName);
            }
        }

        // sets response content type
        response.setContentType("text/html");
        // prints success response
        response.getWriter().println("<h3>file saves successfully to " + uploadPath + "</h3>");
    }
}

// check http://localhost:8080/fetch-employees to see results