//COMPILACION: javac -cp .;%MPJ_HOME%/lib/mpj.jar prodInterno.java
//EJECUCION: mpjrun.bat -np 2 prodInterno 

import mpi.*;
import java.util.Arrays;
/**
 * Clase del ejercicio 1 de la practica 10
 * @author Carlos Antonio Cortés Lora
 */
public class prodInterno {
    public static void main(String args[]) throws Exception {
        MPI.Init(args);

        int id = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        int master = 0; 
        int slave = 1;
        int tag = 100; 
        int unitSize = 10;

        if(id==master){ //codigo del master
            //|fase de envio
            int bufer1[] = new int[unitSize];
            int bufer2[] = new int[unitSize];
            for(int i=0; i<bufer1.length; i++)bufer1[i] = i;
            for(int i=0; i<bufer2.length; i++)bufer2[i] = i;
            MPI.COMM_WORLD.Send(bufer1, 0, unitSize, MPI.INT, slave, tag);
            MPI.COMM_WORLD.Send(bufer2, 0, unitSize, MPI.INT, slave, tag);

            //|fase de recibo
            int revsol[] = new int[1];
            MPI.COMM_WORLD.Recv(revsol, 0, unitSize, MPI.INT, slave, tag);
            System.out.println("SOLUCION: "+ Arrays.toString(revsol));
        } else{ //codigo del slave
            //|fase ed recibo
            int revbufer1[] = new int[unitSize];
            int revbufer2[] = new int[unitSize];
            MPI.COMM_WORLD.Recv(revbufer1, 0, unitSize, MPI.INT, master, tag);
            MPI.COMM_WORLD.Recv(revbufer2, 0, unitSize, MPI.INT, master, tag);
            System.out.println("Recibido revbufer1: "+Arrays.toString(revbufer1));
            System.out.println("Recibido revbufer2: "+Arrays.toString(revbufer2));

            //|fase de envio
            int prodInterno[] = new int[unitSize];
            int resol[] = new int[1];
            for(int i=0; i<prodInterno.length; i++){prodInterno[i] = revbufer1[i] * revbufer2[i];}
            for(int i=0; i<prodInterno.length; i++){ resol[0] += prodInterno[i];}
            System.out.println("Vector Prod: "+Arrays.toString(prodInterno));
            MPI.COMM_WORLD.Send(resol, 0, 1, MPI.INT, master, tag);
        }
        MPI.Finalize();
    }
}