import java.util.*;
/**
 * @author Carlos Antonio Cortés Lora
 * @author 77496883Q
 * 
 * Clase que se usa para crear usaMyBarrier
 */
public class usaMyBarrier extends Thread {
    public myBarrier barrera;

    public usaMyBarrier(myBarrier barrera){
        this.barrera = barrera;
    }


    public void run() {
        try{
            System.out.println(this.getName()+" llegando a la barrera...");
            barrera.toWaitOnBarier();
            System.out.println(this.getName()+" saliendo de la barrera...");
        }catch(Exception e){
            System.out.println("Error en la hebra "+this.getName());
        }
    }
    public static void main(String[] args) throws Exception {
        myBarrier barrera = new myBarrier(3, false);
        Thread h1 = new usaMyBarrier(barrera);
        Thread h2 = new usaMyBarrier(barrera);
        Thread h3 = new usaMyBarrier(barrera);

        h1.start();
        h2.start();
        h3.start();
       
        h1.join();
        h2.join();
        h3.join();   
        
        barrera.resetBarrier();
        System.out.println("Main reseteando la barrera pra tres nuevos hebras");
        
        Thread h4 = new usaMyBarrier(barrera);
        Thread h5 = new usaMyBarrier(barrera);
        Thread h6 = new usaMyBarrier(barrera);
        h4.start();
        h5.start();
        h6.start();
        h4.join();
        h5.join();
        h6.join();

        System.out.println("Main terminado");


        

    }
}
