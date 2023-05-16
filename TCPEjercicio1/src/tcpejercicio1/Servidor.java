/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpejercicio1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SERGIO
 */
public class Servidor {
    
    final static int PUERTO = 2000;
    
    public Servidor(){
        try {
            //Creo el socket del servidor en el puerto 2000
            ServerSocket socketServidor = new ServerSocket(PUERTO);
            System.out.println("Servidor escuchando el puerto 2000");
            
            for (int i=0; i<3; i++){
                //Cojo el servidor del cliente
                Socket socketCliente = socketServidor.accept();
                
                //Flujo de salida
                DataOutputStream flujo_salida = new DataOutputStream(socketCliente.getOutputStream());
                //Mensaje que mostrará el cliente
                flujo_salida.writeUTF("HOLA CLIENTE " + i);
                //Ciero el socket del cliente una vez completada la acción
                socketCliente.close();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[]args){
        new Servidor();
    }
}
