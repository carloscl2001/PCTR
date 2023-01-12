import java.util.concurrent.*;
import java.util.*;

public class usaprodCon implements Runnable {
    
    
    /**
     * Atributo que representa el tipo de proceso
     */
    private int type;

    /**
     * Monitor que vamos a utilizar
     */
    public prodCon monitor;

    /**
     * Constructor de la clase
     * @param monitor
     */
    public usaprodCon(prodCon monitor, int type) {
        this.monitor = monitor;
        this.type = type;
    }

    /**
     * Sobrecarga del método run
     */
    public void run(){
        if(type == 0){
            int item = 1;
            monitor.producir(item++);
        }
        else{
            int item;
            item = monitor.consumir();
            System.out.println("Consumiendo item-> " + item);
        }
    }

    /**
     * Main del ejericicio
     * @param args
     */
    public static void main(String[] args) throws Exception {

        prodCon monitor = new prodCon(5);
        
        Thread h0 = new Thread (new usaprodCon(monitor, 0));
        Thread h1 = new Thread (new usaprodCon(monitor, 1));
        
        h0.start();
        h1.start();
        
        h0.join();
        h1.join();

        monitor.mostrar();
        
    }
}
