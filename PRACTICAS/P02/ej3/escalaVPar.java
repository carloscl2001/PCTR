package ej3;
import java.util.*;
/**
 * @author  Carlos A Cortés Lora
 * @return devuelve un vector generado aleatoriamente y escalado de forma simultánea
 */
public class escalaVPar {

    //Atributos estáticos
    public static final int potencia = 6;
    public static int vector[] = new int[(int)Math.pow(10, potencia)];
    public static final int escalar = 2;

    /**
     * Main del ejercicio
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        //Rellenamos el vector
        for (int i = 0; i < vector.length; i++) {
            vector[i] =(int) Math.random() * 10;
        }

        //Creamos  y lanzamos hilos
        hilo h1 = new hilo(vector[0], vector.length/2, vector, escalar);
        hilo h2 = new hilo(vector.length/2 + 1, vector.length, vector, escalar);
        h1.start();
        h2.start();
        h1.join();
        h2.join();
    }
}


/**
 * Clase hilo que es implementada con Thread, cuya funcion es crear u ejecutar el hilo
 */
class hilo extends Thread {
    //Atributos
    public final int ini;
    public final int fin;
    public int[] vec;
    public final int esc;

    /**
     * Costructor de  hilo
     * @param i inicio de la seccion del vector
     * @param f final de la seccion del vector
     * @param v vector
     * @param e escalar
     */
    public hilo(int i, int f, int[]v, int e){
        ini = i;
        fin = f;
        vec = v;
        esc = e;
    }
    
    /**
     * Funcion que escalar cada numero de la seccion del vector
     */
    public void run()
    {
        for (int i = ini; i < fin; i++) {
            vec[i] *= esc;
        }
    }
}