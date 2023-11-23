/**
 * @author Carlos Antonio Cortés Lora
 * @version tercer intento de dekker
 */
public class algDekker extends Thread {
    
    /**
     * Variables estaticas del algorimtmo de dekker
     */
    private static volatile int n = 0;
    private static volatile int turno = 2;
    private static volatile boolean flag1 = false;
    private static volatile boolean flag2 = false;

    /**
     * Atributo del hilo que representa el identificador del hilo
     */
    private int tipoHilo;

    /**
     * Constructor de la clase algDekker
     * @param tipoHilo
     */
    public algDekker(int tipoHilo) {
        this.tipoHilo = tipoHilo;
    }

    /**
     * Metodo run de la clase
     */
    public void run() {

        //en caso de que el hilo sea 1 sumara a la variable n
        if(tipoHilo == 1) {
            for(int i = 0; i < 10000000; i++) {
                //non-critical section
                flag1 = true;
                while (flag2 == true) {
                    if (turno == 2) {
                        flag1 = false;
                        while (turno != 1);
                        flag1 = true;
                    }
                }
                //critical section
                //System.out.println("Identificador: " + getName());
                n++;
                //System.out.println("n: " + n);

                turno = 2;
                flag1 = false;

            }
        } else{
            //en caso de que el hilo sea 2 restara a la variable n
            for(int i = 0; i < 10000000; i++) {
                //non-critical section

                flag2 = true;
                while (flag1 == true) {
                    if (turno == 1) {
                        flag2 = false;
                        while (turno != 2);
                        flag2 = true;
                    }
                }
                //critical section
                //System.out.println("Identificador: " + getName());
                n--;
                //System.out.println("n: " + n);

                turno = 1;
                flag2 = false;
            }
        }
    }

    
    /**
     * Metodo main de la clase
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Thread h1 = new algDekker(1);
        Thread h2 = new algDekker(2);

        h1.start();
        h2.start();
        System.out.println("_____________________________________________________");
        System.out.println("Valor de n: " + n);
    }
}
