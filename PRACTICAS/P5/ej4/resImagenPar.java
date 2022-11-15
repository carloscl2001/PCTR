import java.util.concurrent.*;
/**
 * Clase para realizar el resaltado de una imagen
 * @author Carlos Antonio Cortés Lora
 * @version concurrente
 */
public class resImagenPar implements Runnable {
    /**
     * Variable estatica para el tamaño de la matriz
     */
    public static final int TAM = 9000;

    /**
     * Variable estatica para la matriz de entrada
     */
    public static int m[][] = new int[TAM][TAM];

    /**
     * Variable estatica para la matriz de salida
     */
    public static int msol[][] = new int[TAM][TAM];

    /**
     * Variable estatica para el numero de hilos
     */
    public static int subramanian = 6;//Runtime.getRuntime().availableProcessors();

    /**
     * Atributo que represenata el limite inferior
     */
    public int lInf;

    /**
     * Atributo que represenata el limite inferior
     */
    public int lSup;

    /**
     * Constructor de la clase
     * @param i limite inferior
     * @param s limite superior
     */
    public resImagenPar(int i, int s){
        lInf = i;
        lSup = s;
    }

    /**
     * Funcion para rellenar la matriz de forma aleatoria
     * @param m matriz 
     */
    public static void rellenarMatriz(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (int)(Math.random()*10);
            }
        }
    }

    /**
     * Sobrecarga del metodo run
     */
    public void run(){
        for(int i = lInf; i < lSup; ++i){
            for(int j = 0; j < TAM; ++j)
            {
                msol[i][j] =  4 * m[i][j];

                //Arrriba
                if( i + 1 < TAM ) msol[i][j] -= m[i + 1][j];
                //Abajo
                if( i - 1 >= 0 ) msol[i][j] -= m[i - 1][j];
                //Derecha
                if( j + 1 < TAM ) msol[i][j] -= m[i][j + 1];
                //Izquierda
                if( j - 1 >= 0 ) msol[i][j] -= m[i][j - 1];
            
                msol[i][j] /= 8;
            }
        }   
    }

    /**
     * Main del ejercicio
     * @param args
     */
    public static void main(String[] args) {

        //Definimos el tamaño de la ventana
        int TamVentana  = TAM/subramanian;

        rellenarMatriz(m);

        //Pool de threads
        ExecutorService executor = Executors.newFixedThreadPool(subramanian);
        for(int i = 0; i < subramanian; i++)
        {
            executor.execute(new resImagenPar(TamVentana * i, TamVentana * (i+1)));
        }
        executor.shutdown();
        while(!executor.isTerminated());   
    }
}
