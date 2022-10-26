/**
 * prodEscalar
 * @author Carlos  Antonio Cortés Lora
 * @version 1.0
 */    
public class prodEscalar{
    //Declaración de variables
    public static final int potencia = 6;
    public static int[] vector1 = new int[(int)Math.pow(10, potencia)];
    public static int[] vector2 = new int[(int)Math.pow(10, potencia)];
    public static int[] resultado = new int[(int)Math.pow(10, potencia)];

    /**
     * Función para rellenar los vectores de lectura con numeros aleatorios
     */
    public static void rellenarVectores(){
        for (int i = 0; i < vector1.length; i++) {
            vector1[i] = (int)(Math.random()*10);
            vector2[i] = (int)(Math.random()*10);
        }
    }

    /**
     * Función para calcular el producto escalar de los vectores y almacenarlo en el vector resultado
     */
    public static void productoEscalar(){
        for (int i = 0; i < vector1.length; i++) {
            resultado[i] = vector1[i] * vector2[i];
        }
    }


    /**
     * Función para mostrar los vectores de lectura y escritura
     */
    public static void mostrarVectores(){
        System.out.println("Vector 1: ");
        for (int i = 0; i < vector1.length; i++) {
            System.out.print(vector1[i] + " ");
        }
        System.out.println();
        System.out.println("Vector 2: ");
        for (int i = 0; i < vector2.length; i++) {
            System.out.print(vector2[i] + " ");
        }
        System.out.println();
        System.out.println("Vector Resultante: ");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i] + " ");
        }
        System.out.println();
    }

    /**
     * Funcion para calcular la suma de los elementos del vector resultado
     * @return suma -> producto escalar
     */
    public static int productoEsc(){
        int sol = 0;
        for (int i = 0; i < resultado.length; i++) {
            sol += resultado[i];
        }
        return sol;
    }

    /**
     * Main del prodEscalar
     */
    public static void main(String[] args) {
        rellenarVectores();
        productoEscalar();
        mostrarVectores();
        System.out.println("La suma de los elementos del vector resultado es: " + productoEsc());
    }
}