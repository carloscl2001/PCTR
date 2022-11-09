import java.util.concurrent.*;

/**
 * @author Carlos Antonio Cortés Lora
 * @version algo de peterson
 */
public class algPeterson implements Runnable{
    /**
     * Varibales estáticas
     */
    private static volatile int nVueltas = 10000;
    private static volatile boolean C1 = false;
    private static volatile boolean C2 = false;
    private static volatile int n = 0;
    private static volatile int last = 1;

     /**
     * Atributo del hilo que representa el identificador del hilo
     */
    private int tipoHilo;

    /**
     * Constructor de la clase algPeterson
     * @param tipoHilo
     */
    public algPeterson(int tipoHilo) {
        this.tipoHilo = tipoHilo;
    }

    /**
     * Metodo run de la clase
     */
    public void run() {
        switch (tipoHilo) {
          case 1: {
            for (int i = 0; i < nVueltas; i++) { //while(true)  ==> Para comprobar limitamos a 1000 iteraciones
                //seccion no critica
                C1 = true;
                last = 1;
                while (C2 && last == 1){};

                //seccion critica
                n++;
                System.out.println("Valor de n: "+ n);
                System.out.println(Thread.currentThread().getName());

                C1 = false;
             
            }
            break;
          }
          case 2: {
              for (int i = 0; i < nVueltas; i++) { //while(true)  ==> Para comprobar limitamos a 1000 iteraciones
                //seccion no critica  
                C2 = true;
                last = 2;
                while (C1 && last == 2){};

                //seccion critica
                n--; 
                System.out.println("Valor de n: "+ n);
                System.out.println(Thread.currentThread().getName());
                  
                C2 = false;
                  
            }
            break;
          
        }
      }
    }

    
    /**
     * Metodo main de la clase
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
         
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new algPeterson(1));
        executor.execute(new algPeterson(2));
        executor.shutdown();
        System.out.println("Valor de n: " + n);
    }
}
