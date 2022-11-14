import java.util.concurrent.*;

/**
 * Clase para realizar el producto de una matriz por un vector de manera concurrente
 * @author Carlos Antonio Cortés Lora
 * @version concurrente
 */
public class prodMatricesParalelo implements Runnable{
    
    //Variables estáticas
    public static int n = 1000;
    public static int m1[][] = new int[n][n];
    public static int m2[][] = new int[n][n];
    public static int msol[][] = new int[n][n];
    public static int subramanian = subramanian(0);
    
    //Atributos de la clase
    public int lInf;
    public int lSup;

    /**
     * Constructor de la clase
     * @param idHebra identificador de la hebra
     */
    public prodMatricesParalelo(int i, int s){
        lInf = i;
        lSup = s;
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


    //funcion para hallar la euacion de Subramanian
    public static int subramanian(int  cb){
        int nt = 0;
        int nc = 20;//Runtime.getRuntime().availableProcessors();
        nt  = nc/(1-cb);
        return nt;
    }

    /**
     * Sobrecarga de metodo run
     */
    @Override
    public  void run(){
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1.length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    for (int l = 0; l < m2.length; l++) {
                        msol[k][l] += m1[i][j] * m2[i][j];
                    }
                }
            }
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

        long iniTiempo = 0;
        long finTiempo = 0;
        
        subramanian(0);
        int TamVentana = n/subramanian;
        System.out.println("n: " + n);
        System.out.println("subrmaian: " + subramanian);
        System.out.println("TamVentana: " + TamVentana);
        
        ExecutorService executor = Executors.newFixedThreadPool(subramanian);
        for(int i = 0; i < subramanian; i++){
            iniTiempo = System.nanoTime();
            executor.execute(new prodMatricesParalelo(i * TamVentana, (i+1) * TamVentana));
            finTiempo = System.nanoTime();
        }
        executor.shutdown();
        while(!executor.isTerminated());
        
        

        System.out.println("Fin del programa");
        System.out.println("Tiempo Total (nanos): "+(finTiempo - iniTiempo));     
    }
}