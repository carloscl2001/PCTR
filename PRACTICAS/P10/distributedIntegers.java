//COMPILACION: javac -cp .;%MPJ_HOME%/lib/mpj.jar distributedIntegers.java
//EJECUCION: mpjrun.bat -np 5 distributedIntegers

import mpi.*;
import java.lang.Math;
import java.util.Random;

import javax.swing.text.Highlighter.Highlight;
/**
 * Clase del ejercicio 3 de la practica 10
 * @author Carlos Antonio Cortés Lora
 */
class distributedIntegers {

    /**
     * Funcion para saber si un numero es primo o no
     * @param numero numero a averiguar si es primo
     * @return bool true en caso de que sea primo
     */
    public static boolean esPrimo(long numero) {
        if (numero == 2) 
            return true;
        if (numero % 2 == 0)
            return false;
        for (long i = 3; i <= Math.sqrt(numero); i += 2)
            if (numero % i == 0)
                return false;
        return true;
    }

    /**
     * Main del ejercicio
     * @param args
     */
    public static void main(String args[]) {

        int id;
        int master = 0;
    	long[] v_rango = new long[1];
    	long[] nPrimos = new long[1];
    	long[] nPrimosTotales = new long[1];
    	long numPrimo = 0;
    	long rango = 1000000;
    	int numTareas = 32;
    	
		MPI.Init(args);

		id = MPI.COMM_WORLD.Rank(); 

        //El proceso master obtiene el tamaño del rango que le corresponde a cada uno
        if (id == master){
			v_rango[0] =(long) rango/numTareas;
		}

		//EL proceso master envia a los demas el tamaño del rango mediante broadcast
		MPI.COMM_WORLD.Bcast(v_rango, 0, 1, MPI.LONG, master);
        
        //Los demas procesos obtienen su tamaño y obtienen el numero de primos que le corresponde
        if(id != master){
            for( long i = id * v_rango[0]; i <= (id + 1) * v_rango[0]; ++i ){
                if(esPrimo(i)){numPrimo++;} 
            }
		    nPrimos[0] = numPrimo;
        }   
		
		//Los demas procesos reducen al master datos parciales y se suman
		MPI.COMM_WORLD.Reduce(nPrimos, 0, nPrimosTotales, 0, 1, MPI.LONG, MPI.SUM, 0);

		//El proceso master meuestra por pantalla la cantidad de numero primos enncontrados en el rango
		if (id == master){
			System.out.println("Numero de primos encontrados en el rango [0 -" + rango + "]: " + nPrimosTotales[0] );
		}

		MPI.Finalize();
    }
}