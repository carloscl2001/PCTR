import ej1.cCRL;

public class cajero implements Runnable{

    //Atributos
    private cCRL cC_;
    private double cantidad_;
    private int operacion_;

    /**
     * Constructoe de cajero
     * @param cC cuentaCorriente
     * @param cantidad 
     * @param operacion tipo de operacion
     */
    public cajero(cCRL cC, double cantidad, int operacion){
        cC_ = cC;
        cantidad_ = cantidad;
        operacion_ = operacion;
    }

    /**
     * Sobrecarga del metodo run
     */
   @Override
   public void run() {
       if(operacion_ == 1)
       {
            System.out.println("Ingresando: " + cantidad_);
            cC_.deposito(cantidad_);
       }else{
            if(operacion_ == 2){
                System.out.println("Reintrego: " + cantidad_);
                cC_.reintegro(cantidad_);
            }
       }
   }
}
