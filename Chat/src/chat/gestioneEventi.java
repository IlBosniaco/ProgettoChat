/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author matte
 */
public class gestioneEventi {

    Condivisa c;

    public gestioneEventi() {
        c = new Condivisa();
    }

    public gestioneEventi(Condivisa c) {
        this.c = c;
    }

    public void connetti() throws UnknownHostException {
        c.setIndirizzoDestinatario(InetAddress.getByName(c.frame.GetAddress()));
        c.aggiungiPacchettoI("c" + c.getNicknameMittente());
        c.sender=true;
    }

    public void disconnetti() {
        c.aggiungiPacchettoI("e");
    }

    public void invia(String messaggio) {
        c.aggiungiPacchettoI("m" + messaggio);
        c.frame.Setlabel(c.frame.GetLabel()+c.getNicknameMittente() + ": " + messaggio+"\n");
    }

    public boolean accetta() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("y->accetta|n->rifiuta");
        do {
            if (reader.readLine().equalsIgnoreCase("y")) {
                return true;
            } else if (reader.readLine().equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("inserire un valore valido");
            }
        } while (true);

    }

    public void aggiungi(String name, String messaggio) {
        c.frame.Setlabel(c.frame.GetLabel()+name + ": " + messaggio+"\n");
    }
}
