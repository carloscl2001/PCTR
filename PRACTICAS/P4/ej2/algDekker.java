/**
 * @author Carlos Antonio Cortés Lora
 * @version version final de dekker
 */
public class algDekker {

    /**
     * Variabales staticas 
     */
    static boolean wantp = false;
    static boolean wantq = false;
    static int turn = 1;


    /**
     * Codigo que ejecuta el proceso p
     */
    class p extends Thread {
        public void run() {
            while(true) {
                //non-critical section
                wantp = true;
                while(wantq){
                    if(turn == 2){
                        wantp = false;
                        while(turn == 1);
                        wantp = true;
                    }
                    wantp = true;
                }
                System.out.println(this.getName());
                turn = 2;
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
                    if(turn == 1){
                        wantq = false;
                        while(turn == 2);
                        wantq = true;
                    }
                    wantq = true;
                }
                System.out.println(this.getName());
                turn = 1;
                wantq = false;
            }

        }
    }

/**
     * Constructor de la clase donde se crean los hilos y se ejecutan
     */
    public algDekker() throws Exception{
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
        new algDekker();
        
    }
}
