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
    InetAddress indirizzoDestinatario;
    String nicknameMittente;
    String nicknameDestinatario;
    boolean connected;
    boolean connecting;
    boolean sender;
    
    public Condivisa(){
        frame = null;
        pacchettiRicevuti = new ArrayList();
        pacchettiDaInviare = new ArrayList();
        indirizzoDestinatario=null;
        nicknameMittente="Matteo";
        nicknameDestinatario="";
        connected = false;
        connecting =false;
        sender=false;
    }
    
    public Condivisa(chatFrame frame){
        this.frame=frame;
        pacchettiRicevuti = new ArrayList();
        pacchettiDaInviare = new ArrayList();
        indirizzoDestinatario=null;
        nicknameMittente="Matteo";
        nicknameDestinatario="";
        connected = false;
        connecting = false;
        sender=false;
    }
    
    public void aggiungiPacchettoR(String p){
        pacchettiRicevuti.add(p);
    }

    public String cancellaPrimoR(){
        return pacchettiRicevuti.remove(0);
    }
    
    public void aggiungiPacchettoI(String p){
        pacchettiDaInviare.add(p);
    }
    
    public String cancellaPrimoI(){
        return pacchettiDaInviare.remove(0);
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
    
    public boolean isEmptyInvio(){
        if(pacchettiDaInviare.size()>0)
        {
            return false;
        }else{
            return true;
        }
    }
    
    public boolean isEmptyRicevi(){
        if(pacchettiRicevuti.size()>0)
        {
            return false;
        }else{
            return true;
        }
    }
}
