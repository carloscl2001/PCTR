import java.util.*;
/**
 * prodEscalar
 * @author Carlos  Antonio Cortés Lora
 * @version 1.0
 */    
public class prodEscalar{
    //Declaración de variables
    public static final int potencia = 6;
    public static final int p = 10;    
    public static int[] vector1 = new int[(int)Math.pow(p, potencia)];
    public static int[] vector2 = new int[(int)Math.pow(p, potencia)];
    public static int[] resultado = new int[(int)Math.pow(p, potencia)];

    /**
     * Funcion para rellenar dos vectores 
     * @param v1
     * @param v2
     */

    public static void rellenarVectores(int v1[],int v2[]){
        for (int i = 0; i < vector1.length; i++) {
            vector1[i] = i;
            vector2[i] = i;
        }
    }
    /**
     * Funcion para multiplicar dos vectores y almacenarlos en v[]
     * @param v vector donde se almacena el resultado
     * @param v1
     * @param v2
     */
    public static void productoEscalar(int v[], int v1[], int v2[]){
        for (int i = 0; i < v1.length; i++) {
            v[i] = v1[i] * v2[i];
        }
    }




    /**
     * Funcion para calcular la suma de los elementos del vector resultado
     * @param v vector donde se almacena el resultado
     * @return suma -> producto escalar
     */
    public static int productoEsc(int v[]){
        int sol = 0;
        for (int i = 0; i < resultado.length; i++) {
            sol += v[i];
        }
        return sol;
    }


    /**
     * Main del prodEscalar
     */
    public static void main(String[] args) {
        rellenarVectores(vector1, vector2);
        
        long startTime = System.nanoTime();
        
        productoEscalar(resultado,vector1, vector2);
        
        long endTime = System.nanoTime();
        
        System.out.println("El producto escalar es: " + productoEsc(resultado));
        System.out.println("Duración: " + (endTime-startTime)/1e6 + " ms");
    }
}