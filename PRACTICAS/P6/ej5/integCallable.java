import java.util.concurrent.*;
import java.util.*;

/**
 * Clase para el ejercicio 5 de la practica 6
 * @author Carlos Antonio Cortes Lora
 */
public class integCallable implements Callable<Integer> {

    /**
     * Variable estatic que representa el numero de tarreas
     */
    public static final int nTareas = Runtime.getRuntime().availableProcessors();

    /**
     * Atributo que representa el limite inferior
     */
    public int lInf = 0;

    /**
     * Atributo que represenAta el limite superior
     */
    public int lSup = 0;
    
    /**
     * Constructor de la clase
     * @param lInf limite inferior
     * @param lSup limite superior
     */
    integCallable(int lInf, int lSup) {
        this.lInf = lInf;
        this.lSup = lSup;
    }

    /**
     * Funcion para calcular el coseno
     * @param x
     * @return el coseno de la variable x
     */
    public static double f(double x){
		return Math.cos(x);
	}

    /**
     * Sobrecarga de call
     * @return valor de tipo Integer, es decir, el numero de veces que se ha producido con exito
     */
    public Integer call() {
        int cont_exito = 0;

        for(int i = lInf; i < lSup; i++){
            Double x = Math.random();
            Double y = Math.random();

            if(y <= f(x) ){cont_exito++;}  
        }
        return cont_exito;   
    }

    public static void main(String[] args) throws Exception{

        //Variable que define el numero de puntos a generar
        int nPuntos = Integer.parseInt(args[0]);

        //Variable que define el tmaño de la ventana
        int tVentana = nPuntos/nTareas;

        //Creamos una lista de objetos future
        List<Future<Integer>> lista = Collections.synchronizedList(new ArrayList<Future<Integer>>());

        //Creamos el executor
        ExecutorService executor = Executors.newFixedThreadPool(nTareas);
        for(int i = 0; i < nTareas; i++){
            lista.add(executor.submit(new integCallable(i*tVentana, (i+1)*tVentana)));
        }
        executor.shutdown();
        while(!executor.isTerminated()){}

        double total = 0.0;
        for(Future<Integer> f : lista){
            total += f.get();
        }
        System.out.println("La integral es: " + total/nPuntos);
    }
    
}