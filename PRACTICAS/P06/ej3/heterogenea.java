/**
 * Clase del ejercicio 3 de la practica 6
 * @author Carlos Antonio Cortes Lora
 */
public class heterogenea {

    public static final Object lock = new Object();
    /**
     * Variable estatica que debemos proteger
     */
    public int n = 10;

    /**
     * Variable estatica no protegida
     */
    public int m = 100;

    /**
     * Metodo protegido para incrementar n
     */
    public void incN() {
        synchronized(lock) {
            n++;
        }
    }

    /**
     * Metodo no protegido para incrementar m
     */
    public void incM() {
        m++;
    }

     /**
     * Metodo protegido para decrementar n
     */
    public void decN(){
        synchronized(lock) {
            n--;
        }
    }

    /**
     * Metodo no protegido para decrementar m
     */
    public void decM(){
        m--;
    }

    /**
     * Main del ejericicio 3
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        heterogenea h = new heterogenea();
        
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    h.incN();
                    h.incM();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    h.decN();
                    h.decM();
                }
            }
        });

        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        System.out.println("n = " + h.n);
        System.out.println("m = " + h.m);
    }

}