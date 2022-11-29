import java.util.concurrent.*;
import java.util.*;

public class usaprodCon implements Runnable {
    
    public static int N = 10;
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
            int item = 0;
            for(int i = 0; i < N; i++){
                monitor.producir(item++);
                System.out.println("Produciendo " + item);
            }
        }
        else{
            int item;
            for(int i = 0; i < N; i++){
                item = monitor.consumir();
                System.out.println("Consumiendo " + item);
            }
        }
    }

    /**
     * Main del ejericicio
     * @param args
     */
    public static void main(String[] args) throws Exception {


        prodCon monitor = new prodCon(10);
        
        ExecutorService executor = Executors.newFixedThreadPool(N);
        for (int i = 0; i < N; i++) {
            executor.execute(new usaprodCon(monitor,i%2));
        }
        executor.shutdown();
        while (!executor.isTerminated()) {}
        monitor.mostrar();
        System.out.println("Finished all threads");
        
        
    }
}
