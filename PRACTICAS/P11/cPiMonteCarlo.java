import java.rmi.*;
import java.rmi.registry.*;
import java.util.Random;
import java.util.Scanner;
/**
 * Clase para la implementacion del cliente del ejercicio 2
 * @author Carlos Antonio Cortés Lora 
 */
public class cPiMonteCarlo {
    
    public static void main(String[] args) throws Exception {
        
        //Se busca el objeto remoto
        iPiMonteCarlo RefObRemoto = (iPiMonteCarlo)Naming.lookup("//localhost/Servidor");
        Scanner s = new Scanner(System.in);
        
        System.out.println("1. Añadir puntos");
        System.out.println("2. Realizar aproximacion");
        System.out.println("3. Resetear el servidor");
        System.out.print("Elige una opcion-> ");
        int opcion = s.nextInt();
        
        switch(opcion){
            case 1:
                RefObRemoto.masPuntos(10000000);
                break;
            case 2:
                System.out.println(RefObRemoto.aproxActual());
                break;
            case 3:
                RefObRemoto.reset();
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
        
        s.close();
    }
    
}
