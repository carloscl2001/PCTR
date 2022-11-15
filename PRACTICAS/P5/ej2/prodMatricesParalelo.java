import java.util.concurrent.*;

/**
 * Clase para realizar el producto de una matriz por un vector de manera concurrente
 * @author Carlos Antonio Cortés Lora
 * @version concurrente
 */
public class prodMatricesParalelo implements Runnable{
    
    //Variables estáticas
    public static int n = 16;
    public static int m1[][] = new int[n][n];
    public static int m2[][] = new int[n][n];
    public static int msol[][] = new int[n][n];
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
        for(int i = 0; i < n; i++){
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

        //imprimirMatriz(m1);
        //imprimirMatriz(m2);
        
        subramanian(0);
        int TamVentana = n/subramanian;
        System.out.println("n: " + n);
        System.out.println("subrmaian: " + subramanian);
        System.out.println("TamVentana: " + TamVentana);
        
        ExecutorService executor = Executors.newFixedThreadPool(subramanian);
        for(int i = 0; i < subramanian; i++){
            executor.execute(new prodMatricesParalelo(i * TamVentana, (i+1) * TamVentana));
        }
        executor.shutdown();
        while(!executor.isTerminated());
        

        System.out.println("Fin del programa");
        imprimirMatriz(msol);
    }
}