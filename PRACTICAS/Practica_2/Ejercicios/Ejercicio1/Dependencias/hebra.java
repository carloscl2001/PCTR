package Ejercicio1.Dependencias;


abstract class  Padre{
    protected static int n;

    public static int n(){
        return n;
    }

    abstract public void fun();
}

class aux1 extends Padre{
    public void fun(){
        n++;
    }
}

class aux2 extends Padre{
    public void fun(){
        n--;
    }
}

/**
 * Clase hebra del Ejercicio 1
 * se encarga de sumar o retas la variable n segun el parametro tipoHilo
 * con un extend Thread y sobrescirto la clase run()
 */

public class hebra extends Thread{
    private  int  tipoHilo;
    private Padre p;
    private  int  nVueltas;

    /** 
     * Cosnstructor paremetrizado
     * @param numero de iteraciones del for
     * @param tipo de hebra, en esta decide si suma o resta la variable compartiad n
    */
    public  hebra(int  nVueltas , int  tipoHilo){
        this.nVueltas=nVueltas; this.tipoHilo=tipoHilo ;
        if (tipoHilo == 0){
            p = new aux1();
        }
        else {
            p = new aux2();
        }
    }

    public int n(){
        return p.n();
    }
    
    /**
     * Funcion que realiza las funcioes del hilo, es uan funcion heredada de a clase Thread
     */

    public  void  run()
    {
        for(int i=0; i<nVueltas; i++){
            p.fun();
        }
    
    }

}
