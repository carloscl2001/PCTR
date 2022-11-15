import java.util.concurrent.*;

/**
 * Clase para hallar los numeros perfectos en un rango de forma paralela
 * @author Carlos Antonio Cortés Lora
 * @version concurrente
 */
public class numPerfectosParalelo implements Callable<Integer> {
    /**
     * Variable estatica que defiene el valor de la ecuacion subramaninan
     */
    static int subramanina = Runtime.getRuntime().availableProcessors();

    /**
     * Atributo que represenata el limite inferior
     */
    public int lInf;

    /**
     * Atributo que represenata el limite inferior
     */
    public int lSup;

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

    public Integer call() throws Exception {
        int total = 0;
        for(int i = lInf; i < lSup; i++){
            if(esPerfecto(i)){
                System.out.println(i);
                return i;
            }   
        }
        return total;
    }
    public static void main(String[] args) throws Exception{
        //Definimso el intervalo de datos
        long intervalo = Long.parseLong(args[0]);

        //Defefinimos el tamaño de la ventana
        int tamVentana = (int)intervalo/subramanina;

        ExecutorService executor = Executors.newFixedThreadPool(subramanina);
        for(int i = 0; i < subramanina; i++){
            executor.execute(new numPerfectosParalelo(tamVentana * i, tamVentana * (i+1)));
        }
        executor.shutdown();
        while(!executor.isTerminated());

    }
}
