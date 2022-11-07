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
    static int n = 0;

    
    /**
     * Codigo que ejecuta el proceso p
     */
    class p extends Thread {
        public void run() {
            while(true){
                //non-critical section
                wantp = true;
                while(wantq){
                    wantp = false;
                    wantp = true;
                }
                n++;
                System.out.println(this.getName());
                wantp = false;

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
                wantq = true;
                while(wantp){
                    wantq = false;
                    wantq = true;
                }
                n--;
                System.out.println(this.getName());
                wantq = false;

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
