import java.util.*;

/**
 * Clase de cuentaCorriente
 * @author Carlos A. Cortés Lora\
 */
public class cuentaCorriente {
    //Atributos
    public final int n_cuenta_;
    private double saldo_;
    private double reintegro_;

    /**
     * Constructor de cuentaCorriente
     * @param n_cuenta
     * @param saldo
     * @param reintegro
     */
    public cuentaCorriente(int n_cuenta, double saldo, double reintegro )
    {
        n_cuenta_ = n_cuenta;
        saldo_  = saldo;
        reintegro_ = reintegro;
    }

    /**
     * Observador del numero de cuenta
     * @return n_cuenta_;
     */
    public int n_cuenta() {return n_cuenta_;}

    /**
     * Observador del saldo
     * @return saldo_
     */
    public double saldo() {return saldo_;}

    /**
     * Observador del reintegro
     * @return reintegro_;
     */
    public double reintegro() {return reintegro_;}

    /**
     * Modificador del saldo
     */
    public void deposito(double n) {saldo_ += n;}

    /**
     * Modificador del reintegro
     */
    public void reintrego(double n) {reintegro_ += n;}

}
