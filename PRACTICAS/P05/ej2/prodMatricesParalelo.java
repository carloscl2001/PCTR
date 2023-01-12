import java.util.concurrent.*;

/**
 * Clase para realizar el producto de una matriz por un vector de manera concurrente
 * @author Carlos Antonio Cortés Lora
 * @version concurrente
 */
public class prodMatricesParalelo implements Runnable{
    
    /**
     * Variable estatica
     */
    public static int N = 2000;

    /**
     * Variable estatica que representa la primera matriz
     */
    public static int m1[][] = new int[N][N];

    /**
     * Variable estatica que representa la segunda matriz
     */
    public static int m2[][] = new int[N][N];

    /**
     * Variable estatica que representa la matriz solucion
     */
    public static int msol[][] = new int[N][N];

    /**
     * Variabel estatica que representae el valor de la ecuacion de subramanian
     */
    public static int subramanian = subramanian(0);
    
    /**
     * Atributo que representa el limite inferior
     */
    public int inferior;

    /**
     * Atributo que representa el limite superior
     */
    public int superior;

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
     * Funcion para hallar al ecuacion de subramanian
     * @param cb coeficiente de bloqueo
     * @return nt valor de la ecuacion
     */
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
        for(int i = 0; i < N; i++){
            msol[inferior][superior] = 1;   
        }
        System.out.println("Hebra " + Thread.currentThread().getName() + " ejecutandose");
    }

    /**
     * Main del ejercicio de la version multihilo
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        rellenarMatriz(m1);
        rellenarMatriz(m2);
        
        subramanian(0);
        int TamVentana = N/subramanian;
        
        ExecutorService executor = Executors.newFixedThreadPool(subramanian);
        for(int i = 0; i < subramanian; i++){
            executor.execute(new prodMatricesParalelo(i * TamVentana, (i+1) * TamVentana));
        }
        executor.shutdown();
        while(!executor.isTerminated());
    }
}