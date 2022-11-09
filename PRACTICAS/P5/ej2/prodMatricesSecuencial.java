/**
 * Clase para ejecutar el ejerciciio de manera secuencial
 * @author Carlos Antonio Cortés Lora
 * @version secuencial
 */
public class prodMatricesSecuencial {

    //Variables estáticas
    public static int n = 3;
    public static int m1[][] = new int[n][n];
    public static int m2[][] = new int[n][n];
    public static int msol[][] = new int[n][n];


    /**
     * Funcion para rellenar una matriz con numeros aleatorios
     * @param m matriz a rellenar
    */
    public static void rellenarMatriz(int m[][]){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (int)(Math.random()*10);
            }
        }
    }


    /**
     * Imprimir por pantalla una matriz
     * @param m matriz a imprimir
     */
    public static void imprimirMatriz(int m[][]){
        System.out.println("Matriz: ");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Imprimir por pantalla un vector
     * @param v vector a imprimir
     */
    public static void imprimirVector(int v[]){
        System.out.println("Vector: ");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

    /**
     *  Funcion para multiplicar una matriz dos matrices y guardar el resultado en unamatriz
     * @param m1 matriz
     * @param m2 matriz
     * @param msol matriz solucion
     */
    public static void productoMatrices(int m1[][], int m2[][], int msol[][]){
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
                for (int k = 0; k < m1[i].length; k++) {
                    msol[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
    }
    

    /**
     * Main del ejercicio de la version secuencial
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        rellenarMatriz(m1);
        rellenarMatriz(m2);

        imprimirMatriz(m1);
        imprimirMatriz(m2);

        System.out.println("\n");
        
        productoMatrices(m1, m2, msol);

        System.out.println("\n\tRESULTADO ");
        imprimirMatriz(msol);
    }
}
