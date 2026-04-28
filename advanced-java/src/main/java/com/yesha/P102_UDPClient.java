package com.yesha;

import java.net.*;

public class P102_UDPClient {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int port = 6000;

        System.out.println("Yesha's UDP Client started.");
        try (DatagramSocket socket = new DatagramSocket()) {
            
            // Prepare packet of info
            String infoPacket = "Hello from Yesha's UDP Client! Here is some information.";
            byte[] sendData = infoPacket.getBytes();
            InetAddress address = InetAddress.getByName(serverAddress);

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);
            System.out.println("Sending UDP Packet: " + infoPacket);
            
            // Send packet
            socket.send(sendPacket);

            // Receive response
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from Server: " + response);

        } catch (Exception e) {
            System.err.println("UDP Client Error: " + e.getMessage());
        }
    }
}
