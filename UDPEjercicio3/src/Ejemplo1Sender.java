
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
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
public class Ejemplo1Sender {
    
    
    public static void main(String[]args){
        
        //Si no se reciven 3 argumentos, se mostrará un mensaje
        if (args.length != 3){
            System.out.println("Debe de introducir 3 argumentos.");
        } else {
            try {
                //Obtengo el host
                InetAddress host = InetAddress.getByName(args[0]);
                
                //Obtengo el puerto
                int puerto = Integer.parseInt(args[1]);
                
                //Obtengo el mensaje
                String mensaje = args[2];
                
                System.out.println("host: " + host);
                System.out.println("puerto: " + puerto);
                System.out.println("menseja: " + mensaje);
                
                //Lo paso a un array de bytes
                byte [] mensajeBytes = mensaje.getBytes();
                
                //Creo la conexión
                DatagramSocket conexion = new DatagramSocket();
                
                //Creo el paquete
                DatagramPacket paquete = new DatagramPacket(mensajeBytes, mensajeBytes.length, host, puerto);
                //Envio el paquete
                conexion.send(paquete);
                System.out.println("Enviando datagrama");
                
                //Cierro el socket
                conexion.close();
            } catch (UnknownHostException ex) {
                Logger.getLogger(Ejemplo1Sender.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SocketException ex) {
                Logger.getLogger(Ejemplo1Sender.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Ejemplo1Sender.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
