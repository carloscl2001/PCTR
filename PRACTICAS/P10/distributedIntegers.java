//COMPILACION: javac -cp .;%MPJ_HOME%/lib/mpj.jar distributedIntegers.java
//EJECUCION: mpjrun.bat -np 5 distributedIntegers

import mpi.*;
import java.lang.Math;
/**
 * Clase del ejercicio 3 de la practica 10
 * @author Carlos Antonio Cortés Lora
 */
class distributedIntegers {

    /**
     * Funcion para saber si un numero es primo o no
     * @param numeor numero a averiguar si es primo
     * @return bool true en caso de que sea primo
     */
    public static boolean esPrimo(int numero) {
        if (numero < 2) 
            return false;
        for (int i = 2; i <= Math.sqrt(numero); i++)
            if (numero % i == 0)
                return false;
        return true;
    }

    /**
     * Main del ejercicio
     * @param args
     */
    public static void main(String args[]) {

        int id, numTareas;
        int master = 0;
    	int[] v_rango = new int[1];
    	int[] nPrimos = new int[1];
    	int[] nPrimosTotales = new int[1];
    	int rango = 10000000;
    	
		MPI.Init(args);

		id = MPI.COMM_WORLD.Rank();
        numTareas = MPI.COMM_WORLD.Size();

        //El proceso master obtiene el tamaño del rango que le corresponde a cada uno
        if (id == master){
			v_rango[0] =(int) rango/numTareas;
		}

		//EL proceso master envia a los demas el tamaño del rango mediante broadcast
		MPI.COMM_WORLD.Bcast(v_rango, 0, 1, MPI.INT, master);
        
        //Los demas procesos obtienen su tamaño y obtienen el numero de primos que le corresponde
        if(id != master){
            for( int i = (id - 1 ) * v_rango[0]; i < (id) * v_rango[0]; i++ ){
                if(esPrimo(i)){nPrimos[0]++;} 
            }
        }   
		
		//Los demas procesos reducen al master datos parciales y se suman
		MPI.COMM_WORLD.Reduce(nPrimos, 0, nPrimosTotales, 0, 1, MPI.INT, MPI.SUM, 0);

		//El proceso master meuestra por pantalla la cantidad de numero primos enncontrados en el rango
		if (id == master){
			System.out.println("Numero de primos encontrados en el rango [0 - " + rango + "]: " + nPrimosTotales[0]);
		}

		MPI.Finalize();
    }
}