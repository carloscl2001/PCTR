/**
 * @author Carlos Antonio Cortés Lora
 * @version cuarto intento de dekker
 */
public class tryFour {
    
    /**
     * Variabales staticas booleanas
     */
    static boolean flagP = false;
    static boolean flagQ = false;
    static int n = 0;

    
    /**
     * Codigo que ejecuta el proceso p
     */
    class p extends Thread {
        public void run() {
            while(true){
                //non-critical section
                flagP = true;
                while(flagQ){
                    flagP = false;
                    flagP = true;
                }
                n++;
                System.out.println(this.getName());
                flagP = false;

                System.out.println(n);
            }
        }
    }


    /**
     * Codigo que ejecuta el proceso q
     */
    class q extends Thread {
        public void run() {
            while(true) {
                //non-critical section
                flagQ = true;
                while(flagP){
                    flagQ = false;
                    flagQ = true;
                }
                n--;
                System.out.println(this.getName());
                flagQ = false;

                System.out.println(n);
            }

        }
    }


    /**
     * Constructor de la clase donde se crean los hilos y se ejecutan
     */
    public tryFour() throws Exception{
        System.out.println("Inicio");
        Thread p = new p();
        Thread q = new q();

        p.start();
        q.start();

        p.join();
        q.join();

        System.out.println(n);
    }

    /**
     * Main del ejercicio 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new tryFour();
        
    }
}
