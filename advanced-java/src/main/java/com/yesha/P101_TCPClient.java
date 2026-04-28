package com.yesha;

import java.io.*;
import java.net.*;

public class P101_TCPClient {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int port = 5000;

        System.out.println("Yesha's TCP Client started.");
        try (Socket socket = new Socket(serverAddress, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to TCP Server at " + serverAddress + ":" + port);

            // Send packet of info
            String infoPacket = "Hello from Yesha's TCP Client! Here is some information.";
            System.out.println("Sending Packet: " + infoPacket);
            out.println(infoPacket);

            // Receive response
            String response = in.readLine();
            System.out.println("Received from Server: " + response);

        } catch (IOException e) {
            System.err.println("TCP Client Error: " + e.getMessage());
        }
    }
}
