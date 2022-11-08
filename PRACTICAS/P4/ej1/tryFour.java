/**
 * @author Carlos Antonio Cortés Lora
 * @version cuarto intento de dekker
 */
public class tryFour extends Thread {
    
    /**
     * Variabales staticas booleanas
     */
    static boolean flagP = false;
    static boolean flagQ = false;
    static int n = 0;

    /**
     * Atributo del hilo que representa el identificador del hilo
     */
    public static int idHilo;


    /**
     * Constructor de la clase tryThree
     */
    public tryFour(int id) {
        idHilo = id;
    }



    /**
     * Metodo run de la clase
     */
    public void run() {

        //en caso de que el hilo sea 1 sumara a la variable n
        if(idHilo == 1) {
            while(true) {
                //non-critical section
                flagP = true;
                while(flagQ){
                    flagP = false;
                    flagP = true;
                }
                //critical section
                System.out.println(this.getName());
                n--;
                System.out.println(n);
                
                flagP = false;
            }
        } else{
            //en caso de que el hilo sea 2 restara a la variable n
            while(true) {
                //non-critical section

                flagQ = true;
                while(flagP){
                    flagQ = false;
                    flagQ = true;
                }
                //critical section
                n++;
                System.out.println(this.getName());
                flagP = false;

                System.out.println(n);
            }
        }
    }


    /**
     * Main del ejercicio 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Inicio");
        Thread h1 = new tryFour(1);
        Thread h2 = new tryFour(2);

        h1.start();
        h2.start();

        h1.join();
        h2.join();

        System.out.println(n);
        
    }
}
