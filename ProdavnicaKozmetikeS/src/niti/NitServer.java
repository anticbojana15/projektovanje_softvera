/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Dragan
 */
public class NitServer extends Thread{
      public NitServer() {
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(9000);
            System.out.println("SERVER PODIGNUT !");
            
            while(true){
                Socket socket = server.accept();
                System.out.println("KLIJENT SE POVEZAO !");
                
                NitObradaKlijenta nitKlijent = new NitObradaKlijenta(socket);
                nitKlijent.start();
            }
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }  
}
