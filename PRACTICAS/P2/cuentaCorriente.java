import java.util.*;

/**
 * Clase de cuentaCorriente
 * @author Carlos A. Cortés Lora\
 */
public class cuentaCorriente {
    //Atributos
    public final int n_cuenta_;
    private double saldo_;

    /**
     * Constructor de cuentaCorriente
     * @param n_cuenta
     * @param saldo
     * @param reintegro
     */
    public cuentaCorriente(int n_cuenta, double saldo)
    {
        n_cuenta_ = n_cuenta;
        saldo_  = saldo;

    }

    

    /**
     * Observador del saldo
     * @return saldo_
     */
    public void saldo(){
        System.out.println("Saldo: " + saldo_);
    }


    /**
     * Modificador del saldo
     */
    public void deposito(double n) {saldo_ += n;}

    /**
     * Modificador del reintegro
     */
    public void reintegro(double n) {saldo_ -= n;}

}
