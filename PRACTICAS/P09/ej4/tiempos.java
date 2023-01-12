import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Clase para medir los tiempos
 * @author Carlos A. Cortés Lora
 */
public class tiempos {

    /**
     * Variable a modificar en casa caso 
     */
    public long N = 0;

    /**
     * Método para medir el tiempo de ejecucución de cerrojos synchronized
     * @param iter numero de iteraciones
     * @return long
     */
    public long f_CerrojoSyncronized(long iter){

        long tiempoIni = System.nanoTime();
        for(int i = 0; i < iter; i++){
            synchronized(this){
                N++;
            }
        }
        long tiempoTotal = System.nanoTime() - tiempoIni;

        return tiempoTotal;
    }

    /**
     * Método para medir el tiempo de ejecucución de cerrojos ReentrantLock
     * @param iter numero de iteraciones
     * @return long
     */
    public long f_CerrojoReentrantLock(long iter){

        ReentrantLock cerrojo = new ReentrantLock();
        long tiempoIni = System.nanoTime();
        for(int i = 0; i < iter; i++){
            cerrojo.lock();
            try{
                N++;
            }finally{
                cerrojo.unlock();
            }
        }
        long tiempoTotal = System.nanoTime() - tiempoIni;

        return tiempoTotal;
    }   

    /**
     * Método para medir el tiempo de ejecucución de semáforos Semaphore
     * @param iter numero de iteraciones
     * @return long
     */
    public long f_Semaforo(long iter){

        Semaphore semaforo = new Semaphore(1);
        long tiempoIni = System.nanoTime();
        for(int i = 0; i < iter; i++){
            try{
                semaforo.acquire();
                N++;
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{
                semaforo.release();
            }
        }
        long tiempoTotal = System.nanoTime() - tiempoIni;

        return tiempoTotal;
    }

    /**
     * Método para medir el tiempo de ejecucución de objetos atomic
     * @param iter numero de iteraciones
     * @return long
     */
    public long f_Atomic(long iter){

        AtomicLong atomic = new AtomicLong(0);
        long tiempoIni = System.nanoTime();
        for(int i = 0; i < iter; i++){
            atomic.incrementAndGet();
        }
        long tiempoTotal = System.nanoTime() - tiempoIni;

        return tiempoTotal;
    }

    /**
     * Main del ejercicio 4, donde se introduce el número de iteraciones
     * @param args
     */
    public static void main(String[] args) {

        long iter = Long.parseLong(args[0]);

        tiempos t1 = new tiempos();
        tiempos t2 = new tiempos();
        tiempos t3 = new tiempos();
        tiempos t4 = new tiempos();

        System.out.println("Tiempo de ejecución con cerrojos synchronized: " + t1.f_CerrojoSyncronized(iter)/1e6 + " milisegundos");
        System.out.println("Tiempo de ejecución con cerrojos ReentrantLock: " + t2.f_CerrojoReentrantLock(iter)/1e6 + " milisegundos");
        System.out.println("Tiempo de ejecución con semáforos Semaphore: " + t3.f_Semaforo(iter)/1e6 + " milisegundos");
        System.out.println("Tiempo de ejecución con objetos atomic: " + t4.f_Atomic(iter)/1e6 + " milisegundos");
        
    }
}
