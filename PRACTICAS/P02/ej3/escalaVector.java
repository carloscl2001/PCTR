package ej3;
import java.util.Vector;
/**
 * @author  Carlos A Cortés Lora
 * @return devuelve un vector generado aleatoriamente y escalado de forma secuencial
 */
public class escalaVector{

    public static int potencia = 6;
    public static int[] datos = new int[(int)(Math.pow(10, potencia))];
	
    public static void main(String[] args) throws Exception{
        
        int escalar = 2;
        //Rellenamos el vector con numeros aleatorios
        for(int  i = 0; i < datos.length; ++i)
        {
            datos[i] = (int)(Math.random() * 10);
        }

        //Escalamos el vector por la variable escalar
        for(int  i = 0; i < datos.length; ++i)
        {
            datos[i] *= escalar;
        }
    }
}
