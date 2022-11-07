/**
 * @author Carlos Antonio Cortés Lora
 * @version version final de dekker
 */
public class algDekker {

    /**
     * Variabales staticas 
     */
    static boolean flagP = false;
    static boolean flagQ = false;
    static int turno = 1;
    static int n = 0;


    /**
     * Codigo que ejecuta el proceso p
     */
    class p extends Thread {
        public void run() {
            for(int i = 0; i < 10000; i++) {
                //non-critical section
                flagP = true;
                while(flagQ == true){
                    if(turno == 2){
                        flagP = false;
                        while(turno != 1);
                        flagP = true;
                    }
                }
                System.out.println(this.getName());
                n++;
                System.out.println(n);
                turno = 2;
                flagP = false;
            }
        }
    }


    /**
     * Codigo que ejecuta el proceso q
     */
    class q extends Thread {
        public void run() {
            for(int i = 0; i < 10000; i++){
                //non-critical section
                flagQ = true;
                while(flagP == true){
                    if(turno == 1){
                        flagQ = false;
                        while(turno != 2);
                        flagQ = true;
                    }
                }
                System.out.println(this.getName());
                n--;
                System.out.println(n);
                turno = 1;
                flagQ = false;
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

        System.out.println("Fin");	
        System.out.println(n);
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