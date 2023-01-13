import java.rmi.*;
import java.rmi.registry.*;
import java.util.Random;

/**
 * Clase para la implementacion del cliente del bonoloto
 * @author Carlos Antonio Cortés Lora 
 */
public class cBonoLoto {
    public static void main(String[] args) throws Exception {
        
        //Vector que contiene la apuesta
        int[] apuesta = new int[6];

        //Se genera la apuesta
        for (int i = 0; i < apuesta.length; ++i) 
            apuesta[i] = (int) (Math.random() * 49 + 1);
        
        //Se busca el objeto remoto
        iBonoLoto RefObRemoto = (iBonoLoto)Naming.lookup("//localhost/Servidor");
        
        //Se compara la apuesta en la loteria
        if(RefObRemoto.compApuesta(apuesta)) 
            System.out.println("Has ganado");
        else 
            System.out.println("Has perdido");
        
        
    }
}
