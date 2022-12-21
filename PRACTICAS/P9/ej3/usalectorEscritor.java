package ej3;
import java.util.Scanner;
import java.util.concurrent.*;
/**
 * Clase para usar el monitor
 * @author Carlos A. Cortés Lora
 */
public class usalectorEscritor implements Runnable{

    /**
     * Variable para comprobar que funciona el monitor
     */
    static long data = 0;

    /**
     * Monitor que vamos a utilizar
     */
    public lectorEscritor monitor;

     /**
     * Atributo que representa el tipo de proceso
     */
    public int tipo;

    /**
     * Constructor de la clase
     * @param monitor
     * @param tipo
     */
    public usalectorEscritor(lectorEscritor monitor, int tipo){
        this.monitor = monitor;
        this.tipo = tipo;
    }    

    /**
     * Sobrecarga del metodo run
     */
    public void run() {
        if(tipo == 1){
            for(long i = 0; i < 1000000; i++){   
                try{monitor.iniciaLectura();}catch(Exception e){}
                data = recurso.observer();
                try{monitor.acabarLectura();}catch(Exception e){}
            }
        }
        else{
            for(long i = 0; i < 1000000; i++){
                try{monitor.iniciaEscritura();}catch(Exception e){}
                recurso.inc();
                try{monitor.acabarEscritura();}catch(Exception e){}
            }
        }
    };
    
    /**
     * Main del ejercicio
     * @param args
     * @throws Exception
     */
    public static void main(String [] args) throws Exception{
        lectorEscritor monitor = new lectorEscritor();

        Thread t1 = new Thread (new usalectorEscritor(monitor, 1));
        Thread t3 = new Thread (new usalectorEscritor(monitor, 1));
        Thread t2 = new Thread (new usalectorEscritor(monitor, 2));
        Thread t4 = new Thread (new usalectorEscritor(monitor, 2));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("El valor final de N es: " + data);
    }
    
}
