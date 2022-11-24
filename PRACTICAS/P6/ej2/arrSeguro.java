import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class arrSeguro extends Thread{

    /**
     * Objeto que actua de cerrojo
     */
    public static final Object lock = new Object();

    /**
     * Atributo que representa el id
     */
    public int id;

    /**
     * Variable del tamaño del array
     */
    public static final int N = 10;
    
    /** 
     * Array de enteros
     */
    public static int[] array = new int[N];

    /**
     * Constructor de la clase
     */
    public arrSeguro(int id){
        this.id = id;
    }

    /**
     * Funcion para rellenar el array con todos los valores a 5
     */
    public static void rellenarArray(){
        for(int i = 0; i < N; i++){
            array[i] = 100;
        }
    }

    /**
     * Funcion para imprimir el array por pantalla
     */
    public static void imprimirArray(){
        for(int i = 0; i < N; i++){
            System.out.println(array[i]);
        }
    }

    /**
     * Cosntructor de la clase
     */
    arrSeguro(){}

    /**
     * Sobrecarga del metodo run
     */
    public void run(){

        for(int i = 0; i < N; i++){
            synchronized(lock){
                array[i]++;
                array[i]++;
                array[i]++;
                array[i]++;
                array[i]++;
                array[i]++;
                array[i]++;
                array[i]++;
                array[i]++;
                array[i]++;
            }   
        }
    }

    /**
     * Main del ejercicio del ejercicio 2
     * @param args
     */
    public static void main(String[] args) {
        rellenarArray();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(6, 12, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        for(int i = 0; i < 10; i++){
            pool.execute(new arrSeguro());
        }
        pool.shutdown();
        while(!pool.isTerminated()){}
        
        imprimirArray();
    }    


}
