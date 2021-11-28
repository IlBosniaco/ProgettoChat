/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matte
 */
public class Condivisa {
    chatFrame frame;   
    List<String> pacchettiRicevuti;
    List<String> pacchettiDaInviare;
    InetAddress indirizzoMittente;
    InetAddress indirizzoDestinatario;
    String nicknameMittente;
    String nicknameDestinatario;
    boolean connected;
    
    public Condivisa(){
        frame = null;
        pacchettiRicevuti = new ArrayList();
        pacchettiDaInviare = new ArrayList();
        indirizzoMittente=null;
        indirizzoDestinatario=null;
        nicknameMittente="";
        nicknameDestinatario="";
        connected = false;
    }
    
    public Condivisa(chatFrame frame){
        this.frame=frame;
        pacchettiRicevuti = new ArrayList();
        pacchettiDaInviare = new ArrayList();
        indirizzoMittente=null;
        indirizzoDestinatario=null;
        nicknameMittente="";
        nicknameDestinatario="";
        connected = false;
    }
    
    public void aggiungiPacchettoR(String p){
        pacchettiRicevuti.add(p);
    }
    
    public void cancellaPacchettoR(int i){
        pacchettiRicevuti.remove(i);
    }
    
    public void cancellaPrimoR(){
        pacchettiRicevuti.remove(0);
    }
    
    public void aggiungiPacchettoI(String p){
        pacchettiDaInviare.add(p);
    }
    
    public void cancellaPacchettoI(int i){
        pacchettiDaInviare.remove(i);
    }
    
    public String cancellaPrimoI(){
        return pacchettiDaInviare.remove(0);
    }

    public InetAddress getIndirizzoMittente() {
        return indirizzoMittente;
    }

    public void setIndirizzoMittente(InetAddress indirizzoMittente) {
        this.indirizzoMittente = indirizzoMittente;
    }

    public InetAddress getIndirizzoDestinatario() {
        return indirizzoDestinatario;
    }

    public void setIndirizzoDestinatario(InetAddress indirizzoDestinatario) {
        this.indirizzoDestinatario = indirizzoDestinatario;
    }
    
    public String getNicknameMittente() {
        return nicknameMittente;
    }

    public void setNicknameMittente(String nicknameMittente) {
        this.nicknameMittente = nicknameMittente;
    }

    public String getNicknameDestinatario() {
        return nicknameDestinatario;
    }

    public void setNicknameDestinatario(String nicknameDestinatario) {
        this.nicknameDestinatario = nicknameDestinatario;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }
    
    
}
