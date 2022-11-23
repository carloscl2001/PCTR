/**
 * Clase dek ejericicio 4 de la practica 6
 * @author Carlos Antonio Cortes Lora
 */
public class deadlock {
    public static void main(String[] args){
        
        /**
         * Creamos la region A
         */
        final Object region_A = new Object();

        /**
         * Creamos la region B
         */
        final Object region_B = new Object();

        /**
         * Creamos la region C
         */
        final Object region_C = new Object();

        /**
         * Variable n
         */
        final int           n = 0;
            
        Thread Hilo_C = new Thread(new Runnable() {
            public void run() {
                synchronized (region_C) {
                    synchronized (region_B) {
                        for (int k = 0; k < 100000; k++) {
                            synchronized (region_A) {
                                System.out.println(n);
                            }
                        }
                    }
                }
            }
        });
        
        Thread Hilo_B = new Thread(new Runnable(){
            public void run() {
                synchronized (region_B) {
                    synchronized (region_A) {
                        for (int k = 0; k < 100000; k++) {
                            synchronized (region_C) {
                                System.out.println(n);
                            }
                        }
                    }
                }
            }
        });
    
        Thread Hilo_A = new Thread(new Runnable(){
            public void run() {
                synchronized (region_A) {
                    synchronized (region_B) {
                        for (int k = 0; k < 100000; k++) {
                            synchronized (region_C) {
                                System.out.println(n);
                            }
                        }
                    }
                }
            }
        });

        Hilo_B.start();
        Hilo_A.start();
        Hilo_C.start();


        System.out.println("Fin");
    }
    
}
