import java.util.*;

public class escalaVPar {

    public static int potencia = 6;
    public static int vector[] = new int[(int)Math.pow(10, potencia)];
    public static int escalar = 2;
    public static void main(String[] args) throws Exception{
        //Rellenamos el vector
        for (int i = 0; i < vector.length; i++) {
            vector[i] =(int) Math.random() * 10;
        }

        hilo h1 = new hilo(vector[0], vector.length/2, vector, escalar);
        hilo h2 = new hilo(vector.length/2 + 1, vector.length, vector, escalar);
        h1.start();
        h2.start();
        h1.join();
        h2.join();
    }
}


/**
 * InnerescalaVPar
 */
class hilo extends Thread {
    public final int ini;
    public final int fin;
    public int[] vec;
    public final int esc;

    public hilo(int i, int f, int[]v, int e){
        ini = i;
        fin = f;
        vec = v;
        esc = e;
    }

    public void run()
    {
        for (int i = ini; i < fin; i++) {
            vec[i] *= esc;
        }
    }

}