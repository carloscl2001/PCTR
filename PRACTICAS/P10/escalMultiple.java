//COMPILACION: javac -cp .;%MPJ_HOME%/lib/mpj.jar escalMultiple.java
//EJECUCION: mpjrun.bat -np 5 escalMultiple 

import mpi.*;
import java.util.Arrays;
/**
 * Clase del ejercicio 2 de la practica 10
 * @author Carlos Antonio Cortés Lora
 */
public class escalMultiple {
    public static void main(String args[]) throws Exception {
        MPI.Init(args);

        int id = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        int master = 0; 
        int tag = 100; 
        int unitSize = 10;

        int bufer[] = new int[unitSize];
        for(int i=0; i<bufer.length; i++)bufer[i] = 0;

        if(id==master){ //codigo del master
            for(int i=0; i<bufer.length; i++)bufer[i] = i;
            System.out.println("Bufer a enviar: "+Arrays.toString(bufer));
        } 

        MPI.COMM_WORLD.Bcast(bufer, 0, unitSize, MPI.INT, master);

        if(id != master){ //codigo de los slave
            for(int i=0; i<bufer.length; i++){bufer[i] *= id;}
            System.out.println("Buffer del slave"+id+": "+Arrays.toString(bufer));
        }
        MPI.Finalize();
    }
}