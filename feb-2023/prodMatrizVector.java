//COMPILACION: javac -cp .;%MPJ_HOME%/lib/mpj.jar prodMatrizVector.java
//EJECUCION: mpjrun.bat -np 3 prodMatrizVector

import mpi.*;
/**
 * @author Carlos Antonio Cortés Lora
 * @author 77496883Q
 */
public class prodMatrizVector {

    //Metodo para pasar de matriz a vector
    public static void matrizToVector(int[][] matriz, int[] vector){
        int k = 0;
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                vector[k] = matriz[i][j];
                k++;
            }
        }
    }

    //Metodo para pasar de vector a matriz
    public static void vectorToMatriz(int[] vector, int[][] matriz){
        int k = 0;
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                matriz[i][j] = vector[k];
                k++;
            }
        }
    }


    public static void main(String[] args) {
        MPI.Init(args);
        int id = MPI.COMM_WORLD.Rank();
        int master = 0;
        int tag = 100;
        int tag1 = 101;
        int N = 3;
        
        if(id == master){
            int matrizM[][] = {{0,2,4},{6,8,10},{12,14,16}};
            int vectorV[] = new int[N*N];
            int vectorM[] = new int[N*N];
            int vectorS[] = new int[N];
            int vectorProdResult[] = new int[N];
            matrizToVector(matrizM, vectorM);
            MPI.COMM_WORLD.Scatter(vectorM, 0, N, MPI.INT, vectorS, 0, N, MPI.INT, master);
            

            MPI.COMM_WORLD.Bcast(vectorV, 0, 1, MPI.INT, master);
            for(int i=0; i<3; i++){
                vectorProdResult[master] = vectorS[i] * vectorV[i];
            }
            int vector2[] = new int[1];
            int vector3[] = new int[1];
            MPI.COMM_WORLD.Recv(vector2, 0, 1, MPI.INT, 1, tag1);
            MPI.COMM_WORLD.Recv(vector3, 0, 1, MPI.INT, 2, tag1);
            vectorProdResult[1] = vector2[0];
            vectorProdResult[2] = vector3[0];
            System.out.println("Vector producto resultante: " + vectorProdResult[0] + " " + vectorProdResult[1] + " " + vectorProdResult[2]);


        }else if(id == 1){
            int vector1[] = new int[1];
            int vectorS[] = new int[N];
            int vectorV1[] = new int[1];
            MPI.COMM_WORLD.Recv(vectorV1, 0, 3, MPI.INT, master, tag);
            for(int i=0; i<3; i++){
                vector1[0] = vectorS[i] * vectorV1[i];
            }
            MPI.COMM_WORLD.Send(vector1, 0, 1, MPI.INT, master, tag1);
            
        }else if(id == 2){
            int vector2[] = new int[1];
            int vectorS[] = new int[N];
            int vectorV1[] = new int[1];
            MPI.COMM_WORLD.Recv(vectorV1, 0, 3, MPI.INT, master, tag);
            for(int i=0; i<3; i++){
                vector2[0] = vectorS[i] * vectorV1[i];
            }
            MPI.COMM_WORLD.Send(vector2, 0, 1, MPI.INT, master, tag1);
        }
        MPI.Finalize();
    }
}
