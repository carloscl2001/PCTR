//COMPILACION: javac -cp .;%MPJ_HOME%/lib/mpj.jar distributedIntegers.java
//EJECUCION: mpjrun.bat -np 5 distributedIntegers

import mpi.*;
import java.util.Arrays;
/**
 * Clase del ejercicio 3 de la practica 10
 * @author Carlos Antonio Cortés Lora
 */
public class distribIntegers {
    public static void main(String args[]) throws Exception {
        MPI.Init(args);

        int id = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        int master = 0; 
        int tag = 100; 
        int unitSize = 10;
        long rango = 100000000;

        MPI.COMM_WORLD.Bcast()
      

        
        MPI.Finalize();
    }
}