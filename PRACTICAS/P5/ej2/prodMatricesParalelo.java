import java.util.concurrent.*;

import javax.swing.event.TableModelEvent;

/**
 * Clase para realizar el producto de una matriz por un vector de manera concurrente
 * @author Carlos Antonio Cortés Lora
 * @version concurrente
 */
public class prodMatricesParalelo implements Runnable{
    
    //Variables estáticas
    public static int n = 3;
    public static int m1[][] = new int[n][n];
    public static int m2[][] = new int[n][n];
    public static int msol[][] = new int[n][n];
    public static int subramanian = subramanian(0);
    

    int inferior;
    int superior;

    /**
     * Constructor de la clase
     * @param idHebra identificador de la hebra
     */
    public prodMatricesParalelo(int i, int s){
        inferior = i;
        superior = s;
    }

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

    //funcion para hallar la euacion de Subramanian
    public static int subramanian(int  cb){
        int nt = 0;
        int nc = Runtime.getRuntime().availableProcessors();
        nt  = nc/(1-cb);
        return nt;
    }

    /**
     * Sobrecarga de metodo run
     */
    @Override
    public void run(){
        //multpilicar dos matrices de nxn
        for (int i = inferior; i < superior; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    msol[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
    }


    /**
     * Main del ejercicio de la version multihilo
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        rellenarMatriz(m1);
        rellenarMatriz(m2);

        imprimirMatriz(m1);
        imprimirMatriz(m2);
        
        subramanian(0);
        int TamVentana = n/subramanian;
        
        ExecutorService executor = Executors.newFixedThreadPool(subramanian);
        for(int i = 0; i < subramanian; i++){
            Runnable worker = new prodMatricesParalelo(i * TamVentana, (i+1) * TamVentana);
        }
        executor.shutdown();

        imprimirMatriz(msol);

    }
}