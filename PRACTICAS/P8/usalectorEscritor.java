import java.util.Scanner;
import java.util.concurrent.*;
/**
 * Clase que defiene el monitor que incorpora acceso seguro al buffer
 */
public class usalectorEscritor implements Runnable{
    
    /**
     * Creamos el monitor
     */
    public static lectorEscritor monitor = new lectorEscritor();

    /**
     * Atributos que representa el tipo de hilo
     */
    public int tipoHilo;

    /**
     * Constructor de la clase
     * @param tipoHilo
     */
    public usalectorEscritor(int tipoHilo){
        this.tipoHilo = tipoHilo;
    }
    
    /**
     * Sobrecarga del metodo run
     */
    public void run(){
        if(tipoHilo == 0){
            monitor.prodBuffer(); 
            
        }else{
            monitor.conBuffer(); 
        } 
    }
    
    /**
     * Main del ejercicio
     * @param args
     * @throws Exception
     */
    public static void main(String [] args) throws Exception{

        //Obtenemos el numero de hilos a crear
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el numero de hilos:");
        int n_Hilos = sc.nextInt();
        sc.close();
        System.out.println("-----------------------------");

        //Creamoos y ejecutamos un pool de threads
        ExecutorService executor = Executors.newFixedThreadPool(n_Hilos);
        for(int i=0; i<n_Hilos; i++){
            executor.execute(new usalectorEscritor(i%2));
        }
        executor.shutdown();
        while(!executor.isTerminated()){}

        //Imprimimos el buffer
        monitor.mostrarBuffer();
    }
    
}
