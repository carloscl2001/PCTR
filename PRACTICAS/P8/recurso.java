/**
 * Clase recurso que contiene la variable N y los metodos para incrementarla y mostrarla por pantalla
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
    public synchronized void inc() {
        N++;
    }

    /**
     * Metodo para imprimir la variable
     */
    public synchronized void observer(){
        System.out.println(N);
    }
}
