import java.util.*;
public class resImagen {

    /**
     * Variable estatica para el tamaño de la matriz
     */
    public static int n = 9000;

    /**
     * Variable estatica para la matriz de entrada
     */
    public static int m[][] = new int[n][n];

    /**
     * Funcion para rellenar la matriz de forma aleatoria
     * @param m matriz 
     */
    public static void rellenarMatriz(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (int)(Math.random()*10);
            }
        }
    }

    /**
     * Funcion para resaltar
     * @param m matriz
     */
    static public void resal(int m[][])
    {
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j)
            {
                m[i][j] =  4 * m[i][j];

                //Arriba
                if( i + 1 < n ) m[i][j] -= m[i + 1][j];
                //Abajo
                if( i - 1 >= 0 ) m[i][j] -= m[i - 1][j];
                //Derecha
                if( j + 1 < n ) m[i][j] -= m[i][j + 1];
                //Izquierda
                if( j - 1 >= 0 ) m[i][j] -= m[i][j - 1];
                
                m[i][j] /= 8;
            }
        }   
    }
    
   
    /**
     * Main del ejercicio
     * @param args
     */
    public static void main(String[] args) {
        rellenarMatriz(m);
        resal(m);
    }
}
