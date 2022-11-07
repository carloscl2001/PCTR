/**
 * @author Carlos Antonio Cortés Lora
 * @version tercer intento de dekker
 */
public class tryThree {
    /**
     * Variabales staticas booleanas
     */
    public static boolean flagP = false;
    public static boolean flagQ = false;
    static int n = 0;

    
    /**
     * Codigo que ejecuta el proceso p
     */
    class p extends Thread {
        public void run() {
            for(int i = 0; i < 100000; i++){
                //non-critical section
                flagP = true;
                while(flagQ != false);   
                System.out.println(this.getName());
                n++;          
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
            for(int i = 0; i < 100000; i++){
                //non-critical section
                flagQ = true;
                while(flagP != false);
                System.out.println(this.getName());
                n--;     
                flagQ = false;
                System.out.println(n);
            }
        }
    }
    
    /**
     * Constructor de la clase donde se crean los hilos y se ejecutan
     */
    public tryThree() throws Exception{

        Thread p1 = new p();
        Thread q1 = new q();

        p1.start();
        q1.start();

        p1.join();
        q1.join();
    
    }
     
    /**
     * Main del ejercicio 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new tryThree();
    }
}