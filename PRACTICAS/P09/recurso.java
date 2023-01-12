package ej3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Clase recurso que contiene la variable N y los metodos para incrementarla y observarla
 * @author Carlos A. Cortés Lora
 */
public class recurso {
    /**
     * Variable encapuslada
     */
    static long N = 0;

    /**
     * Lock para el recurso
     */
    static ReentrantLock lock = new ReentrantLock();

    /**
     * Metodo para incrementar la variable
     */
    public static void inc() {
        N++;
    }

    /**
     * Metodo para observar la variable
     */
    public static long observer(){
        return N;
    }
}
