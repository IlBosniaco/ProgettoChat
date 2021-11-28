/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matte
 */
public class ThreadRicevi extends Thread{
    private DatagramSocket ricevi;
    private Condivisa c;
    
    public ThreadRicevi() throws SocketException {
        this.ricevi = new DatagramSocket(2003);
        this.c = new Condivisa();
    }

    public ThreadRicevi(Condivisa c) throws SocketException {
        this.ricevi = new DatagramSocket(2003);
        this.c = c;
    }
    
    @Override
    public void run() {
        while(true){                       
            byte[] bufferRicevi = c.cancellaPrimoI().getBytes();
            DatagramPacket packet = new DatagramPacket(bufferRicevi, bufferRicevi.length);
            try {
                ricevi.receive(packet);
            } catch (IOException ex) {
                Logger.getLogger(ThreadRicevi.class.getName()).log(Level.SEVERE, null, ex);
            }
            byte[] dataReceived = packet.getData();
            String messaggio = new String(dataReceived, 0, packet.getLength());
            
            if(messaggio.substring(0, 1).equals("c")&&c.connected==true){
                c.aggiungiPacchettoR("d");//nega connessione
            }else{
                c.aggiungiPacchettoR(messaggio);
            }
        }
    }
}
