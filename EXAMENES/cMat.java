//COMPILACION: javac -cp .;%MPJ_HOME%/lib/mpj.jar cMat.java
//EJECUCION: mpjrun.bat -np 4 cMat


import mpi.*;

/**
 * cMat
 */
public class cMat {

    //Metodo para pasar de matriz a vector
    public static void matrizToVector(float[][] matriz, float[] vector){
        int k = 0;
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                vector[k] = matriz[i][j];
                k++;
            }
        }
    }

    //Metodo para pasar de vector a matriz
    public static void vectorToMatriz(float[] vector, float[][] matriz){
        int k = 0;
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                matriz[i][j] = vector[k];
                k++;
            }
        }
    }

    //Metodo para imprimir una matriz por pantalla
    public static void imprimirMatriz(float[][] matriz, String mensaje){
        String linea = "";
        linea += mensaje + "\n";
        linea += "-----------------------" + "\n";
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                if(j % 2 == 0 && j != 0){
                    linea += matriz[i][j] + "\n";
                }
                else{
                    linea += matriz[i][j] + " ";
                }
            }
        }
        linea += " " + "\n";
        System.out.println(linea);
    }

    //Metodo para multiplicar dos matrices
    public static void multiplicarMatrices(float[][] matrizA, float[][] matrizB, float[][] matrizC){
        for(int i=0; i<matrizA.length; i++){
            for(int j=0; j<matrizB.length; j ++){
                for(int k=0; k<matrizA.length; k++){
                    matrizC[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
    }

    //Metodo para hacer la matriz transpuesta
    public static void transpuesta(float[][] matriz, float[][] matrizT){
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                matrizT[j][i] = matriz[i][j];
            }
        }
    }

    
    public static void main(String[] args) {
        MPI.Init(args);
        int id = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        int master = 0;
        int tag = 100;
        int tagt = 200;
        int N = 3;

        if(id == master){
            float matrizA[][] = {{1,2,3},{4,5,6},{7,8,9}};
            float matrizB[][] = {{1,0,0},{0,1,0},{0,0,1}};
            float matrizC[][] = new float[N][N];
            float vectorA[] = new float[N*N];
            float vectorB[] = new float[N*N];
            float vectorC[] = new float[N*N];
            matrizToVector(matrizA, vectorA);
            matrizToVector(matrizB, vectorB);
            
            MPI.COMM_WORLD.Send(vectorA, 0, N*N, MPI.FLOAT, 1, tag);
            MPI.COMM_WORLD.Send(vectorB, 0, N*N, MPI.FLOAT, 1, tag);
            MPI.COMM_WORLD.Send(vectorA, 0, N*N, MPI.FLOAT, 2, tag);
            MPI.COMM_WORLD.Send(vectorB, 0, N*N, MPI.FLOAT, 2, tag);
            MPI.COMM_WORLD.Send(vectorA, 0, N*N, MPI.FLOAT, 3, tag);

            
            MPI.COMM_WORLD.Recv(vectorC, 0, N*N, MPI.FLOAT, 3, tagt);
            vectorToMatriz(vectorC, matrizC);
            String mensaje = "Matriz transpuesta de A";
            imprimirMatriz(matrizC, mensaje);
        }
        else if(id == 1){
            float vectorA[] = new float[N*N];
            float vectorB[] = new float[N*N];
            float matrizA[][] = new float[N][N];
            float matrizB[][] = new float[N][N];
            MPI.COMM_WORLD.Recv(vectorA, 0, N*N, MPI.FLOAT, master, tag);
            MPI.COMM_WORLD.Recv(vectorB, 0, N*N, MPI.FLOAT, master, tag);
            vectorToMatriz(vectorA, matrizA);
            vectorToMatriz(vectorB, matrizB);
            float matrizC[][] = new float[N][N];
            
            //funcion para sumar dos matrices y gaurdarlo en matrizC
            for(int i=0; i < matrizA.length; i++){
                for(int j=0; j < matrizB.length; j++){
                    matrizC[i][j] = matrizA[i][j] + matrizB[i][j];
                }
            }
            String mensaje = "Matriz resultado de la suma de las dos matrices";
            imprimirMatriz(matrizC, mensaje);
            
        }else if(id == 2){
            float vectorA[] = new float[N*N];
            float vectorB[] = new float[N*N];
            float matrizA[][] = new float[N][N];
            float matrizB[][] = new float[N][N];
            MPI.COMM_WORLD.Recv(vectorA, 0, N*N, MPI.FLOAT, master, tag);
            MPI.COMM_WORLD.Recv(vectorB, 0, N*N, MPI.FLOAT, master, tag);
            vectorToMatriz(vectorA, matrizA);
            vectorToMatriz(vectorB, matrizB);
            float matrizC[][] = new float[N][N];
            multiplicarMatrices(matrizA, matrizB, matrizC);
            String mensaje = "Matriz resultado de la multiplicacion de las dos matrices";
            imprimirMatriz(matrizC, mensaje);

        }else if(id == 3){
            float matrizA[][] = new float[N][N];
            float matrizB[][] = new float[N][N];
            float vectorA[] = new float[N*N];
            float vectorB[] = new float[N*N];

            MPI.COMM_WORLD.Recv(vectorA, 0, N*N, MPI.FLOAT, master, tag);
            vectorToMatriz(vectorA, matrizA);
            transpuesta(matrizA, matrizB);
            
            matrizToVector(matrizB, vectorB);
            
            MPI.COMM_WORLD.Send(vectorB, 0, N*N, MPI.FLOAT, master, tagt);
        }
        MPI.Finalize();
    }
    
}