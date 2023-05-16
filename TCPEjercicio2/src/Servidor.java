
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
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
public class Servidor {
    
    static final int PUERTO = 2000;
    
    public Servidor(){
        try {
            //Creo el socket del servidor
            ServerSocket socketServidor = new ServerSocket(PUERTO);
            System.out.println("Escucho el puerto " + PUERTO);
            
            //Para cada uno de los 3 clientes...
            for (int i=0; i<3; i++){
                //Obtengo el socket del cliente aceptando la conexión
                Socket socketCliente = socketServidor.accept();
                System.out.println("SIRVO AL CLIENTE " + i);
                
                //Creo el flujo de entrada que viene del cliente
                DataInputStream flujo_entrada = new DataInputStream(socketCliente.getInputStream());
                //Leo la String que se mandó desde el cliente
                System.out.println(flujo_entrada.readUTF());
                
                //Cierro el socket del cliente
                socketCliente.close();
            }
            
            System.out.println("Ya se han atendido los 3 clientes");
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[]args){
        new Servidor();
    }
}
