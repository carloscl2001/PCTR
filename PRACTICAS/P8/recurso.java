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
     * Metodo para incrementar la variable
     */
    public static synchronized void inc() {
        N++;
    }

    /**
     * Metodo para observar la variable
     */
    public static synchronized long observer(){
        return N;
    }
}
