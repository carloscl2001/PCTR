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
            int item = 5;
            monitor.producir(item);
        }
        else{
            monitor.consumir();
        }
    }

    /**
     * Main del ejericicio
     * @param args
     */
    public static void main(String[] args) throws Exception {

        prodCon monitor = new prodCon(5);
        
        Thread h0 = new Thread (new usaprodCon(monitor, 0));
        Thread h1 = new Thread (new usaprodCon(monitor, 0));
        Thread h2 = new Thread (new usaprodCon(monitor, 0));
        Thread h3 = new Thread (new usaprodCon(monitor, 1));
        Thread h4 = new Thread (new usaprodCon(monitor, 1));
        Thread h5 = new Thread (new usaprodCon(monitor, 1));
        
        h0.start();
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();

        h0.join();
        h1.join();
        h2.join();
        h3.join();
        h4.join();
        h5.join();
        
    }
}
