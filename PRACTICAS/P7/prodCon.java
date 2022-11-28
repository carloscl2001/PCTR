/**
 * Clase que define el monitor que incorpora acceso seguro al buffer
 */
public class prodCon {

    /**
     * Variable que representa el tamaño del buffer
     */
    static int N = 50;

    /**
     * Vector de tamaño N que representa el buffer
     */
    private int buffer[] = new int[N];

    public prodCon(){}

    /**
     * Metodo que incrementa el buffer
     */
    public synchronized void incBuffer(){
       for(int i=0; i<N; i++){
           buffer[i]++;
       }
    }
    
    /**
     * Metodo que decrementa el buffer
     */
    public synchronized void decBuffer(){
        for(int i=0; i<N; i++){
            buffer[i]--;
        }
    }

    /**
     * Metodo que imprime el buffer por pantalla
     */
    public synchronized void mostrarBuffer(){
        for(int i=0; i<N; i++){
            System.out.println(buffer[i]);
        }
    }
}
