/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat;


/**
 *
 * @author matte
 */
public class gestioneEventi {
    Condivisa c;
    
    public gestioneEventi(){
        c=new Condivisa();
    }
    
    public gestioneEventi(Condivisa c){
        this.c=c;
    }
    
    public void connetti(){
        c.aggiungiPacchettoI("c"+c.getNicknameMittente());  
    }
        
    public void disconnetti(){
        c.connected=false;
        c.connecting=false;
    }
    
    public void invia(String messaggio){
        c.aggiungiPacchettoI("m"+messaggio);
    }
    
    public boolean accetta(){
        return true;
    }
    
    public void aggiungi(String name, String messaggio){
        c.frame.Setlabel(name+": "+messaggio);
    }
}
