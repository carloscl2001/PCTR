import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Clase de cuentaCorriente con semáforos de la clase Semaphore
 * @author Carlos A. Cortés Lora
 */
public class ccSem {
    /**
     * Atributos de cuentaCorriente-> n_cuenta_ y saldo_
     */
    public final int n_cuenta_;
    private double saldo_;

    /**
     * ReentrantLock
     */
    private Semaphore sem;

    /**
     * Constructor de cuentaCorriente
     * @param n_cuenta
     * @param saldo
     */
    public ccSem(int n_cuenta, double saldo)
    {
        n_cuenta_ = n_cuenta;
        saldo_  = saldo;
        this.sem = new Semaphore(1);
    }

    

    /**
     * Observador del saldo
     * @return saldo_
     */
    public void saldo(){
        try{sem.acquire();}
        catch(InterruptedException e){}
        try{System.out.println("Saldo: " + saldo_);}
        finally{sem.release();}
    }


    /**
     * Modificador del saldo
     */
    public void deposito(double n) {
        try{sem.acquire();}
        catch(InterruptedException e){}
        try{saldo_ += n;}
        finally{sem.release();}
    }

    /**
     * Modificador del reintegro
     */
    public void reintegro(double n) {
        try{sem.acquire();}
        catch(InterruptedException e){}
        try{saldo_ -= n;}
        finally{sem.release();}
    }

}
