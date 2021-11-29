/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matte
 */
public class ThreadInvio extends Thread {

    private DatagramSocket invia;
    private Condivisa c;

    public ThreadInvio() throws SocketException {
        this.invia = new DatagramSocket(2003);
        this.c = new Condivisa();
    }

    public ThreadInvio(Condivisa c) throws SocketException {
        this.invia = new DatagramSocket(2003);
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            if (!c.isEmptyInvio()) {
                String messaggio = c.cancellaPrimoI();
                byte[] bufferInvia = messaggio.getBytes();
                DatagramPacket packet = new DatagramPacket(bufferInvia, bufferInvia.length);
                packet.setAddress(c.getIndirizzoDestinatario());
                packet.setPort(2003);
                try {
                    invia.send(packet);
                } catch (IOException ex) {
                    Logger.getLogger(ThreadInvio.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (messaggio.equals("e")) {
                    c.connected = false;
                    c.connecting = false;
                    c.setIndirizzoDestinatario(null);
                    c.setNicknameDestinatario("");
                    c.frame.Setlabel("");
                    c.sender=false;
                }
            }
        }
    }
}
