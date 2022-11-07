/**
 * @author Carlos Antonio Cortés Lora
 * @version cuarto intento de dekker
 */
public class tryFour {
    
    /**
     * Variabales staticas booleanas
     */
    static boolean wantp = false;
    static boolean wantq = false;

    
    /**
     * Codigo que ejecuta el proceso p
     */
    class p extends Thread {
        public void run() {
            while(true) {
                //non-critical section
                wantp = true;
                while(wantq){
                    wantp = false;
                    wantp = true;
                }
                System.out.println(this.getName());
                wantp = false;
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
                wantq = true;
                while(wantp){
                    wantq = false;
                    wantq = true;
                }
                System.out.println(this.getName());
                wantq = false;
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
