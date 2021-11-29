/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat;


/**
 *
 * @author matte
 */
public class ThreadElabora extends Thread{
    private Condivisa c;
    private gestioneEventi g;

    public ThreadElabora() {
        this.c = new Condivisa();
        this.g =new gestioneEventi();
    }

    public ThreadElabora(Condivisa c, gestioneEventi g){
        this.c = c;
        this.g=g;
    }

    @Override
    public void run() {
        while (true) {
            if (!c.isEmptyRicevi()) {
                String pacchetto = c.cancellaPrimoR();
                String comando = pacchetto.substring(0, 1);
                String messaggio="";
                if(pacchetto.length()>1){
                    messaggio = pacchetto.substring(1, pacchetto.length());
                }
                
                if(comando.equals("c")){          
                    if(g.accetta())
                    {
                        c.setNicknameDestinatario(messaggio);
                        c.aggiungiPacchettoI("y"+c.getNicknameMittente());
                        c.connecting=true;
                    }else{
                        c.aggiungiPacchettoI("n");
                    }
                }
                else if(comando.equals("y")){
                    if(c.connecting == false){
                        if(g.accetta()){
                            c.setNicknameDestinatario(messaggio);
                            c.aggiungiPacchettoI("y"+c.getNicknameMittente()); 
                            c.connecting=true;
                        }else{
                            c.aggiungiPacchettoI("n");
                        }
                    }else{
                        if(g.accetta()){
                            c.aggiungiPacchettoI("y");
                            c.connected=true;
                        }else{
                            c.aggiungiPacchettoI("n");
                        }
                    }
                }
                else if(comando.equals("n")){
                    c.connected=false;
                    c.connecting=false;
                }
                else if(comando.equals("m")){
                    g.aggiungi(c.getNicknameDestinatario(),messaggio);
                }
                else if(comando.equals("e")){
                    c.connected=false;
                    c.connecting=false;
                }else if(comando.equals("d")){
                    c.aggiungiPacchettoI("n");
                }
            }
        }
    }
}
