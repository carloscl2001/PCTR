/**
 * @author Carlos Antonio Cortés Lora
 * @version tercer intento de dekker
 */
public class tryThree extends Thread {
    /**
     * Variabales staticas booleanas
     */
    public static boolean flagP = false;
    public static boolean flagQ = false;
    static int n = 0;

    /**
     * Atributo del hilo que representa el identificador del hilo
     */
    public static int idHilo;
    
    /**
     * Constructor de la clase tryThree
     */
    public tryThree(int id){
        idHilo = id;
    }
    

    /**
     * Metodo run de la clase
     */
    public void run() {

        //en caso de que el hilo sea 1 sumara a la variable n
        if(idHilo == 1) {
            while(true){
                //non-critical section
                flagP = true;
                while(flagQ != false);
                System.out.println(this.getName());
                n++;
                System.out.println(n);     
                flagP = false;
                
            }
        } else{
            //en caso de que el hilo sea 2 restara a la variable n
            while(true) {
                //non-critical section
                flagQ = true;
                while(flagP != false);
                System.out.println(this.getName());
                n--;
                System.out.println(n);     
                flagQ = false;
            }
        }
    }
     
    /**
     * Main del ejercicio 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Thread h1 = new tryThree(1);
        Thread h2 = new tryThree(2);

        h1.start();
        h2.start();

        h1.join();
        h2.join();
    }
}