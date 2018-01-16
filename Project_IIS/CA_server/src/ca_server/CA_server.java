/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author wesam
 */
public class CA_server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
                int Port = 5787;
                int NumberOfThreads = 40;        
                ServerSocket server = new ServerSocket(Port);
                Socket Client=null;
                ExecutorService threadExecutor = Executors.newFixedThreadPool(NumberOfThreads);//pooling
                Task Threads[] = new Task[NumberOfThreads];
                System.out.println("CA_Server Waiting...");
                int j=0;
                while(true){
                    System.out.println("zzzzzzzz...");
                    Client = server.accept();
                    System.out.println("1111...");
                    Threads[j] = new Task(Client);                   
                    threadExecutor.execute(Threads[j]);
                    
                    j++;
            }//end loop while
        } //end main
        catch (Exception ex) {
            Logger.getLogger(CA_server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end main
}//end class
