import java.util.*;
/**
 * Clase que almacena los metodos y atributos necesarios
 * 
 * @author Carlos Antonio Cortés Lora
 */

public class hebra extends Thread{

    private int tipoHilo ;
    public static int n = 0; // variable de clase
    private int nVueltas ;
    

    /**
     * Constructor de una hebra
     * @param nVueltas 
     * @param tipoHilo
     * @return crea una hebra
     */
    public hebra(int nVueltas, int tipoHilo)
    { 
        this.nVueltas = nVueltas; 
        this.tipoHilo = tipoHilo;
    }
    
    /**
     * Método que aumenta y decrementa n la misma cantidad según el hilo
     */
    public void run() {
        switch ( tipoHilo ) {
        case 0: for(int i =0; i < nVueltas ; i ++) n++; break ;
        case 1: for(int i =0; i < nVueltas ; i ++) n--; break ;
        }
    }

    public static int n() {return n;}
}