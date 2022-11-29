import java.util.concurrent.*;

public class usaprodCon implements Runnable {
    
    public int type;
    //creacion de un objeto de tipo prodCon
    public prodCon monitor;

    public usaprodCon(prodCon monitor, int type){
        this.monitor = monitor;
        this.type = type;
    }
    
    public void run(){
        if(type == 0){
            monitor.producir();
        }
        else{
            monitor.consumir();
        }
    }

    public static void main(String[] args) throws Exception {
        int buffer [] = new int[10];
        prodCon monitor = new prodCon(buffer);
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
            executor.execute(new usaprodCon(monitor,i%2));
        }
        executor.shutdown();
        while (!executor.isTerminated()) {}
        monitor.mostrar();
        
    }
}
