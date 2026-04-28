package com.yesha;

import java.net.*;

public class P102_UDPServer {
    public static void main(String[] args) {
        int port = 6000;

        System.out.println("Yesha's UDP Server started on port " + port);
        try (DatagramSocket socket = new DatagramSocket(port)) {
            byte[] receiveData = new byte[1024];

            System.out.println("Waiting for UDP packet...");

            // Receive packet
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String receivedInfo = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received Packet from Client " + receivePacket.getAddress().getHostAddress() + ": " + receivedInfo);

            // Send response
            String response = "UDP Packet received successfully by Yesha's Server.";
            byte[] sendData = response.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
            socket.send(sendPacket);
            System.out.println("Response sent to client.");

        } catch (Exception e) {
            System.err.println("UDP Server Error: " + e.getMessage());
        }
    }
}
