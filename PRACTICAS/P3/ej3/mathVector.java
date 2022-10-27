/**
 * Clase para ejecutar el ejerciciio de manera secuencial
 * @author Carlos Antonio Cortés Lora
 */
public class mathVector {

    //Variables estáticas
    public static int n = 4;
    public static int m[][] = new int[n][n];
    public static int v[] = new int[n];
    public static int r[] = new int[n];


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
     * Funcion para rellenar un vector con numeros aleatorios
     * @param v vector a rellenar
     */
    public static void rellenarVector(int v[]){
        for (int i = 0; i < v.length; i++) {
            v[i] = (int)(Math.random()*10);
        }
    }

    /**
     * Imprimir por pantalla una matriz
     * @param m matriz a imprimir
     */
    public static void mostrarMatriz(int m[][]){
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
    public static void mostrarVector(int v[]){
        System.out.println("Vector: ");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

    /**
     *  Funcion para multiplicar una matriz por un vector y guardar el resultado en otro vector
     * @param m matriz
     * @param v vector
     * @param r vector solucion
     */
    public static void multiplicarMatrizVector(int m[][], int v[], int r[]){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                r[i] += m[i][j] * v[j];
            }
        }
    }

    /**
     * Main del ejercicio secuencial
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        rellenarMatriz(m);
        rellenarVector(v);

        mostrarMatriz(m);
        System.out.println("\n");
        mostrarVector(v);

        multiplicarMatrizVector(m, v, r);

        System.out.println("\n\tRESULTADO ");
        mostrarVector(r);
    }
}
