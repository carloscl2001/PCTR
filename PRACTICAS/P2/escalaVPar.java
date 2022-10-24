import java.util.*;

public class escalaVPar {

    public static int potencia = 6;
    public static int vector[] = new int[(int)Math.pow(10, potencia)];

    public static void main(String[] args) throws Exception{
        //Rellenamos el vector
        for (int i = 0; i < vector.length; i++) {
            vector[i] =(int) Math.random() * 10;
        }
    }
}
