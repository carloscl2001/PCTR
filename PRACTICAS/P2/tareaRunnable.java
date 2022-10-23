import java.util.*;
/**
 * Clase que almacena los metodos y atributos necesarios para una hebra
 * 
 * @author Carlos Antonio Cortés Lora
 */

public class tareaRunnable implements Runnable{

    private int tipoHilo ;
    public static int n = 0; // variable de clase
    private int nVueltas ;
    

    /**
     * Constructor de una hebra
     * @param nVueltas 
     * @param tipoHilo
     * @return crea una hebra
     */
    public tareaRunnable(int nVueltas, int tipoHilo)
    { 
        this.nVueltas = nVueltas; 
        this.tipoHilo = tipoHilo;
    }
    /**
     * Modificador -> incrementa n en 1
     */
    public void aumenta()
    {
        n++;
    }

    /**
     * Modificador -> reduce n en 1
     */
    public void reduce()
    {
        n--;
    }

    /**
     * Observador de var 
     * {@code n}
     * @return n
     */
    public int n_()
    {
        return n;
    }
    
    /**
     * Método que aumenta y decrementa n la misma cantidad según el hilo
     */
    public void run() {
        switch ( tipoHilo ) {
        case 0: for(int i =0; i < nVueltas ; i ++) aumenta(); break ;
        case 1: for(int i =0; i < nVueltas ; i ++) reduce(); break ;
        }
    }
    
    /**
     * Método que devuelve el valor de la variable estática n
     * @return n ->variable estatica de la clase hebra
     */
}