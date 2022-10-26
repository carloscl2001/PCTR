import java.util.*;
/**
 * prodEscalar
 * @author Carlos  Antonio Cortés Lora
 * @version 1.0
 */    
public class prodEscalar{
    //Declaración de variables
    public static final int potencia = 1;
    public static int[] vector1 = new int[(int)Math.pow(5, potencia)];
    public static int[] vector2 = new int[(int)Math.pow(5, potencia)];
    public static int[] resultado = new int[(int)Math.pow(5, potencia)];

    /**
     * Funcion para rellenar dos vectores de forma aleatoria
     * @param v1
     * @param v2
     */
    public static void rellenarVectores(int v1[], int v2[]){
        for (int i = 0; i < vector1.length; i++) {
            v1[i] = (int)(Math.random()*10);
            v2[i] = (int)(Math.random()*10);
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
     * Funcion para imprimir los vectores
     * @param v1
     * @param v2
     * @param v
     */
    public static void mostrarVectores(int v1[], int v2[], int v[]){
        System.out.println("Vector 1: ");
        for (int i = 0; i < vector1.length; i++) {
            System.out.print(v1[i] + " ");
        }
        System.out.println();
        System.out.println("Vector 2: ");
        for (int i = 0; i < vector2.length; i++) {
            System.out.print(v2[i] + " ");
        }
        System.out.println();
        System.out.println("Vector Resultante: ");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

    /**
     * Main del prodEscalar
     */
    public static void main(String[] args) {
        rellenarVectores(vector1, vector2);
        productoEscalar(resultado,vector1, vector2);
        mostrarVectores(vector1, vector2, resultado);
        System.out.println("El producto escalar es: " + productoEsc(resultado));
    }
}