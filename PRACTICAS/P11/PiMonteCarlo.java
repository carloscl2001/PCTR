import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;
import java.util.Random;

/**
 * Clase para la implemntacion del servidor del ejercicio 2
 * @author Carlos Antonio Cortés Lora
 */
public class PiMonteCarlo extends UnicastRemoteObject implements iPiMonteCarlo{

    /**
     * Atributo que representa el numero de puntos para la aproximacion
     */
    private int nPuntos;

    /**
     * Atributo que representa el valor de Pi
     */
    private double Pi;

    /**
     * Atributo que representa el numero de puntos que caen dentro del circulo
     */
    private int cont_exito;

    /**
     * Metodo para reiniciar el servidor
     * @throws RemoteException
     */
    public void reset() throws RemoteException {
        nPuntos = 0;
        Pi = 0;
        nPuntos = 0;
        cont_exito = 0;
    };

    /**
     * Metodo para añadir puntos a la aproximacion
     * @throws RemoteException
     */
    public void masPuntos(int nPuntos) throws RemoteException {
        this.nPuntos += nPuntos;
        MonteCarlo();
    };

    /**
     * Metodo para realiza el metodo de MonteCarlo
     * @throws RemoteException
     */
    public void MonteCarlo() throws RemoteException {
        for(int i = 0; i < nPuntos; i++){
            double x = Math.random();
            double y = Math.random();
    
            if(y <= Math.sqrt(1 - Math.pow(x, 2)) )
                cont_exito++;
        }
        cont_exito *= 4;
        Pi = (double) cont_exito / nPuntos;
    };

    /**
     * Metodo para obtener el valor de Pi 
     * @throws RemoteException
     * @return el valor de Pi
     */
    public double aproxActual() throws RemoteException {
        return Pi;
    };

    /**
     * Constructor de la clase
     * @throws RemoteException
     */
    PiMonteCarlo() throws RemoteException {
        reset();
    }
    
    /**
     * Main del servidor
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        //creamos el objeto remoto
        iPiMonteCarlo obj = new PiMonteCarlo();

        //Se registra el servicio
        Naming.rebind("Servidor", obj);
        System.out.println("Servidor preparado");
    }
}



