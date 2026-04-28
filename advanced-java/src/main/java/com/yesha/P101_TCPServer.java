package com.yesha;

import java.io.*;
import java.net.*;

public class P101_TCPServer {
    public static void main(String[] args) {
        int port = 5000;

        System.out.println("Yesha's TCP Server started on port " + port);
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Waiting for client connection...");

            // Try-with-resources for client connection
            try (Socket clientSocket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Read packet of info from client
                String receivedPacket = in.readLine();
                System.out.println("Received Packet: " + receivedPacket);

                // Send response
                String response = "TCP Packet received successfully by Yesha's Server.";
                out.println(response);
                System.out.println("Response sent to client.");
            }

        } catch (IOException e) {
            System.err.println("TCP Server Error: " + e.getMessage());
        }
    }
}
