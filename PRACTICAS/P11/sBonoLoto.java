import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;
import java.util.Random;

/**
 * Clase para la implemntacion del servidor del bonoloto
 * @author Carlos Antonio Cortés Lora 
 */
public class sBonoLoto extends UnicastRemoteObject implements iBonoLoto{

    /**
     * Vector con los numeros de la loteria
     */
    public int[] loteria = new int[6];
   
    /**
     * Constructor de la clase
     * @throws RemoteException
     */
    public sBonoLoto() throws RemoteException {
        resetServidor();
    }

    /**
     * Metodo para reiniciar el servidor
     * @throws RemoteException
     */
    public void resetServidor() throws RemoteException{
        for (int i = 0; i < loteria.length; ++i) 
            loteria[i] = (int) (Math.random() * 49 + 1);
        
    }

    /**
     * Metodo para comparar la apuesta con la loteria
     * @return true si la apuesta es correcta, false en caso contrario
     */
    public boolean compApuesta(int[] apuesta) throws RemoteException {   
        boolean ganador = true;
		for( int i = 0; i < loteria.length; ++i )
            if( loteria[i] != apuesta[i] ) ganador = false;
        
		return ganador;
    } 

    /**
     * Main del servidor
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        //creamos el objeto remoto
        iBonoLoto obj = new sBonoLoto();

        //Se registra el servicio
        Naming.bind("Servidor", obj);
        System.out.println("Servidor BonoLoto preparado");
    }
}


