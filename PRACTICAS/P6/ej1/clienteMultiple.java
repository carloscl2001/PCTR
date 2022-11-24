/**
 * Clase dekl cliente del ejericicio 1 de la practica 6
 * @author Carlos Antonio Cortes Lora
 */

import java.net.*;
import java.io.*;
/**
 * Clase clienteMultiple que lanza varias peticiones al servidor
 */
public class clienteMultiple{
    
    /**
     * Método main de la clase clienteMultiple.
     * @param args
     */
    public static void main (String[] args){
        
        try{
            for(int i = 0; i < 10; i++){
                int aux = (int)(Math.random()*10);
                System.out.println("Realizando conexion...");
                Socket cable = new Socket("localhost", 2001);
                System.out.println("Realizada conexion a " + cable);
                PrintWriter salida= new PrintWriter(
                                        new BufferedWriter(
                                            new OutputStreamWriter(
                cable.getOutputStream())));
                salida.println(aux);
                salida.flush();
                System.out.println("Cerrando conexion...");
                cable.close();
            }
            

        }catch (Exception e){
            System.out.println("Error en sockets...");
        }
    
    }//main
}//Cliente_Hilos
