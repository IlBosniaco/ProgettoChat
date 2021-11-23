/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientchat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matte
 */
public class ClientChat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, IOException {
        // TODO code application logic here

        DatagramSocket client = new DatagramSocket(12345);
        byte[] buffer = new byte[1500];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        Scanner reader = new Scanner(System.in);
        String messaggioRicevuto = "";

        while (true) {
            String input = "";
            
            do {
                while (input.equals("")) {
                    input = reader.nextLine();
                }

                
                client.receive(packet);
                byte[] dataReceived = packet.getData(); // copia del buffer dichiarato sopra
                messaggioRicevuto = new String(dataReceived, 0, packet.getLength());
                System.out.println(messaggioRicevuto);
            } while (messaggioRicevuto.equals("n"));

            
            String risposta = "";            
            do {
                while (!(risposta.equals("y")||risposta.equals("n"))) {
                    risposta = reader.nextLine();
                }

                
                client.receive(packet);
                byte[] dataReceived = packet.getData(); // copia del buffer dichiarato sopra
                messaggioRicevuto = new String(dataReceived, 0, packet.getLength());
                System.out.println(messaggioRicevuto);
            } while (messaggioRicevuto.equals("n"));

            
            
            byte[] responseBuffer = risposta.getBytes();
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            responsePacket.setAddress(packet.getAddress());
            responsePacket.setPort(packet.getPort());

            client.send(responsePacket);

        }

    }
}
