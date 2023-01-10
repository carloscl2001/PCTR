import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;
import java.util.Random;

public class sBonoLoto extends UnicastRemoteObject implements iBonoLoto{
    public int[] loteria = new int[6];
   
    public sBonoLoto() throws RemoteException {
        resetServidor();
    }

    public void resetServidor(){
        for (int i = 0; i < loteria.length; ++i) {
            loteria[i] = (int) (Math.random() * 49 + 1);
        }
    }

    public boolean compApuesta(int[] apuesta) throws RemoteException {   
        boolean ganador = true;
		for( int i = 0; i < loteria.length; ++i ){
            if( loteria[i] != apuesta[i] ) ganador = false;
        }
		return ganador;
    } 

    public static void main(String[] args) throws Exception {
        iBonoLoto obj = new sBonoLoto();
        Naming.bind("Servidor", obj);
        System.out.println("Servidor BonoLoto preparado");
    }
}
