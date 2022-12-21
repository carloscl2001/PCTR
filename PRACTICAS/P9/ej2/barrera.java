package ej2;
import java.util.concurrent.CyclicBarrier;

/**
 * Clase barrera del segundo ejercicio de la practica 9
 * @author Carlos A. Cortés Lora
 */
public class barrera extends Thread{

    /**
     * Barrera que controla el paso de los hilos
     */
    CyclicBarrier barrera;

    /**
     * Constructor de la clase barrera
     * @param barrera barrera que controla el paso de los hilos
     */
    public barrera(CyclicBarrier barrera){
        this.barrera = barrera;
    }

    /**
     * Metodo run de la clase barrera
     */
    @Override
    public void run() {
        try {
            int i = barrera.await();
            System.out.println("El hilo "+this.toString()+" esperando a los demas hilos...");
        } catch (BrokenBarrierException e) {
            System.out.println("Excepcion de BrokenBarrier...");
        }
        catch (InterruptedException e) {
            System.out.println("Excepcion de Interrrupted...");
        }
        System.out.println("El hilo "+this.toString()+" paso la barrera...");
    }
    
    /**
     * Main de la clase barrera
     * @param args
     */
    public static void main(String[] args) {
        CyclicBarrier barrera = new CyclicBarrier(3);
        Thread hilo1 = new Thread(new Innerbarrera(barrera));
        Thread hilo2 = new Thread(new Innerbarrera(barrera));
        Thread hilo3 = new Thread(new Innerbarrera(barrera));
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
    
}
