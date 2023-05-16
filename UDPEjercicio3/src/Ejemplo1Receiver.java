
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
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
public class Ejemplo1Receiver {
    
    public static void main(String[]args){
        try {
            
            //Obtengo el puerto
             int port = Integer.parseInt(args[0]);
             
            //Creo la conexión
            DatagramSocket conexion = new DatagramSocket(port);
            
            //Creo la array de byte
            byte [] mensaje = new byte[10];
            
            //Creo el paquete. Parametros: Array de byte, longitud de esa array
            DatagramPacket paquete = new DatagramPacket(mensaje, 10);
            
            //Recibo el paquete
            conexion.receive(paquete);
            
            String message = new String(mensaje);
            System.out.println(message);
            
            //Cierro la conexion
            conexion.close();
        } catch (SocketException ex) {
            Logger.getLogger(Ejemplo1Receiver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejemplo1Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
