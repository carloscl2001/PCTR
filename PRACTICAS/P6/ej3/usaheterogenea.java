/**
 * Clase del ejercicio 3 - usahetrogenea de la practica 6
 * @author Carlos Antonio Cortes Lora
 */
public class usaheterogenea {


    public static void main(String[] args) throws Exception{

        /**
         * Creamos onjeto de la clase heterogenea que nos sirva para proteger la variable n
         */
        final heterogenea h = new heterogenea();

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
