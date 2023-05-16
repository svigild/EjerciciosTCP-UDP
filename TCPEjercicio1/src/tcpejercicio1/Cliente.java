/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpejercicio1;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SERGIO
 */
public class Cliente {
    
    final static String HOST = "localhost";
    final static int PUERTO = 2000;
    
    public Cliente(){
        try {
            //Creo el socket del cliente
            Socket socketCliente = new Socket(HOST, PUERTO);
            
            //Flujo de entrada
            DataInputStream flujo_entrada = new DataInputStream(socketCliente.getInputStream());
            //Muestro el flujo de entrada
            System.out.println(flujo_entrada.readUTF());
            //Cierro el socket
            socketCliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[]args){
        new Cliente();
    }
}
