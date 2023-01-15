//COMPILACION: javac -cp .;%MPJ_HOME%/lib/mpj.jar cMat.java
//EJECUCION: mpjrun.bat -np 4 cMat

import rmi.*;

/**
 * cMat
 */
public class cMat {

    //Metodo para pasar de matriz a vector
    public void matrizToVector(float[][] matriz, float[] vector){
        int k = 0;
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                vector[k] = matriz[i][j];
                k++;
            }
        }
    }

    //Metodo para pasar de vector a matriz
    public void vectorToMatriz(float[] vector, float[][] matriz){
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
        int size = MPI.COMM_WORLD.Size();
        int master = 0;
        int tag = 100;
        int N = 3;

        if(id == master){
            matrizA = new float[N][N];
            matrizB = new float[N][N];
            matrizA = {{1,2,3},{4,5,6},{7,8,9}};
            matrizB = {{1,0,0},{0,1,0},{0,0,1}};
            vectorA = new float[N*N];
            vectorB = new float[N*N];
            matrizToVector(matrizA, vectorA);
            matrizToVector(matrizB, vectorB);
            for(int i= 1; i < 5; i++){
                MPI.COMM_WORLD.Send(vectorA, 0, N*N, MPI.FLOAT, i, tag);
                MPI.COMM_WORLD.Send(vectorB, 0, N*N, MPI.FLOAT, i, tag);
            }
        }


    }
    
}