import java.util.concurrent.*;
import java.util.*;

/**
 * Clase para hallar los numeros perfectos en un rango de forma paralela
 * @author Carlos Antonio Cortés Lora
 * @version concurrente
 */
public class numPerfectosParalelo implements Callable<Integer> {
    /**
     * Variable estatica que defiene el valor de la ecuacion subramaninan
     */
    static int subramanina = 32;//Runtime.getRuntime().availableProcessors();

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
     * @param lInf limite inferior
     * @param lSup limite superior
     */
    public numPerfectosParalelo(int lInf, int lSup) {
        this.lInf = lInf;
        this.lSup = lSup;
    }

    /**
     * Funcion para comprobar si un numero es perfecto
     * @param n numero a comprobar
     * @return true si es perfecto, false en caso contrario
     */
    static boolean esPerfecto(long n) {
        long suma = 0;

        for (long i = 1; i < n; ++i){if (n % i == 0) suma += i;}
            
        if (n == suma){return (true);}
        else{return (false);}
    }

    /**
     * Sobrecarga de call
     */
    public Integer call() {
        int total = 0;
        for(int i = lInf; i < lSup; i++){
            if(esPerfecto(i))
                if(i != 0)
                total++;
            }
        return total;
    }
        


    public static void main(String[] args) throws Exception{
        //Definimso el intervalo de datos
        long intervalo = Long.parseLong(args[0]);

        //Creamos una lista de objetos future
        List<Future<Integer>> lista = Collections.synchronizedList(new ArrayList<Future<Integer>>());

        //Defefinimos el tamaño de la ventana
        int tamVentana = (int)intervalo/subramanina;

        long inicTiempo = System.nanoTime();
        //Creamos el pool de hilos
        ExecutorService executor = Executors.newFixedThreadPool(subramanina);
        for(int i = 0; i < subramanina; i++){
            
            lista.add(executor.submit(new numPerfectosParalelo(tamVentana * i, tamVentana * (i+1))));

        }
        executor.shutdown();
        while(!executor.isTerminated());
        Float tiempoTotal = (System.nanoTime()-inicTiempo)/(float)1.0e9;
        
        //Recorremos la lista de objetos future
        int total = 0;
        for(Future<Integer> f : lista){
            total += f.get();
        }
        System.out.println("Total de numeros perfectos: " + total);
        System.out.println("Tiempo total: " + tiempoTotal + " segundos");
    }
}
