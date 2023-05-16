
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
            
            //Genero un número aleatorio desde el 1 hasta el 10
            int numeroAleatorio = (int) ((Math.random()*10)+1);
            
            //Creo el flujo de salida
            DataOutputStream flujo_salida = new DataOutputStream(socketCliente.getOutputStream());
            
            //En el flujo de salida escribo la String correspondiente
            flujo_salida.writeUTF("Mensaje de salida del cliente que se envía al servidor, He pensado en el número… " + numeroAleatorio);
            System.out.println("Mensaje a enviar al servidor. Salió un " + numeroAleatorio);
            
            //Ciero el socket del cliente
            socketCliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[]args){
        new Cliente();
    }
}
