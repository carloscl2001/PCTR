import java.net.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.io.*;


/**
 * Clase del Servidor del ejericicio 1 de la practica 6
 * @author Carlos Antonio Cortes Lora
 */
class ServidorHiloConPool implements Runnable{

    /**
     * Atributo de tipo Socket que representa el socket del cliente.
     */
    Socket enchufe;

    /**
     * Constructor de la clase 
     * @param s Socket del cliente
     */
    public ServidorHiloConPool(Socket socket){
        enchufe = socket;
    }

    /**
     * Método run de la clase ServidorHiloConPool. 
     */
    public void run(){
        try{
            BufferedReader entrada = new BufferedReader(
                                        new InputStreamReader(
                                            enchufe.getInputStream()));
            String datos = entrada.readLine();
            int i = Integer.valueOf(datos).intValue();
            int aux;
            for(aux = 1; aux <= 20; aux++){
                System.out.println("El hilo " + Thread.currentThread().getName() +  " escribiendo el dato "+i);
                Thread.sleep(1000);
            }

            enchufe.close();
            System.out.println("El hilo " + Thread.currentThread().getName() + "cierra su conexion...");

        } catch(Exception e) {System.out.println("Error...");}
    }//run

    /**
     * Main de la clase ServidorHiloConPool
     * @param args
     */
    public static void main (String[] args){
        int puerto = 2001;
            
        try{
            ServerSocket chuff = new ServerSocket (puerto, 3000);

            while (true){
                
                ThreadPoolExecutor pool = new ThreadPoolExecutor(6, 12, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

                System.out.println("Esperando solicitud de conexion...");
                Socket cable = chuff.accept();

                System.out.println("Recibida solicitud de conexion..."); 
                pool.execute(new ServidorHiloConPool(cable));
            }//while
        } catch (Exception e){System.out.println("Error en sockets...");}
    }//main

}//Servidor_Hilos
