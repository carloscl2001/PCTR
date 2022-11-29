/**
 * Clase que define el monitor que incorpora acceso seguro al buffer
 */
public class lectorEscritor {

    /**
     * Variable que representa el tamaño del buffer
     */
    static int N = 50;

    /**
     * Vector de tamaño N que representa el buffer
     */
    private int buffer[] = new int[N];

    public lectorEscritor(){}

    /**
     * Metodo para producir el buffer
     */
    public synchronized void prodBuffer(){
       for(int i=0; i<N; i++){
           buffer[i]= 10;
       }
    }
    
    
    /**
     * Metodo para consumir el buffer
     */
    public synchronized void conBuffer(){
        for(int i=0; i<N; i++){
            buffer[i]= 0;
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
