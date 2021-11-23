/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serverchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

/**
 *
 * @author matte
 */
public class ServerChat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, IOException {
        // TODO code application logic here

        DatagramSocket server = new DatagramSocket(2003);
        byte[] buffer = new byte[1500];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        Scanner reader = new Scanner(System.in);
        String messaggioRicevuto = "";

        while (true) {

            server.receive(packet);
            byte[] dataReceived = packet.getData(); // copia del buffer dichiarato sopra
            messaggioRicevuto = new String(dataReceived, 0, packet.getLength());
            System.out.println(messaggioRicevuto);

            String risposta = "";
            String nickname = "";
            do {
                while (!(risposta.equals("y") || risposta.equals("n"))) {
                    risposta = reader.nextLine();
                }

                while (risposta.equals("")) {
                    nickname = reader.nextLine();
                }

            } while (messaggioRicevuto.equals("n"));

            risposta += nickname;

            byte[] responseBuffer = risposta.getBytes();
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            responsePacket.setAddress(packet.getAddress());
            responsePacket.setPort(packet.getPort());

            server.send(responsePacket);

            server.receive(packet);
            dataReceived = packet.getData(); // copia del buffer dichiarato sopra
            messaggioRicevuto = new String(dataReceived, 0, packet.getLength());
            System.out.println(messaggioRicevuto);

        }

    }

}
