import java.rmi.*;
import java.rmi.registry.*;
import java.util.Random;

public class cBonoLoto {
    public static void main(String[] args) throws Exception {
        
        int[] apuesta = new int[6];

        for (int i = 0; i < apuesta.length; ++i) {
            apuesta[i] = (int) (Math.random() * 49 + 1);
        }

        iBonoLoto RefObRemoto = (iBonoLoto)Naming.lookup("//localhost/Servidor");
        
        if(RefObRemoto.compApuesta(apuesta)) {
            System.out.println("Has ganado");
        } else {
            System.out.println("Has perdido");
        }
        
    }
}
