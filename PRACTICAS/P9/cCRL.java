import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Clase de cuentaCorriente con un cerrojo de clase ReentrantLock
 * @author Carlos A. Cortés Lora
 */
public class cCRL {
    /**
     * Atributos de cuentaCorriente-> n_cuenta_ y saldo_
     */
    public final int n_cuenta_;
    private double saldo_;

    /**
     * ReentrantLock
     */
    public ReentrantLock lock = new ReentrantLock();

    /**
     * Constructor de cuentaCorriente
     * @param n_cuenta
     * @param saldo
     * @param reintegro
     */
    public cCRL(int n_cuenta, double saldo)
    {
        n_cuenta_ = n_cuenta;
        saldo_  = saldo;
    }

    

    /**
     * Observador del saldo
     * @return saldo_
     */
    public void saldo(){
        lock.lock();
        System.out.println("Saldo: " + saldo_);
        lock.unlock();
    }


    /**
     * Modificador del saldo
     */
    public void deposito(double n) {
        lock.lock();
        try{saldo_ += n;}
        finally{lock.unlock();}
    }

    /**
     * Modificador del reintegro
     */
    public void reintegro(double n) {
        lock.lock();
        try{saldo_ -= n;}
        finally{lock.unlock();}
    }

}
