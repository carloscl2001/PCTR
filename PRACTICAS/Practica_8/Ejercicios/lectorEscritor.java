
/**
 * Clase monitor de lectura escritura
 */

public class lectorEscritor {
    private static boolean escribiendo = false;
    private static int lectores = 0;


    /**
     * Constructor de la clase lectorEscritor
     */

    public lectorEscritor(){}

    /**
     * metodo para iniciar la lectura
     */

    public synchronized void iniciaLectura(){
            while (escribiendo) { try { wait(); } catch (InterruptedException e) {e.printStackTrace();} } 
            lectores++;
            notifyAll();
    }

    /**
     * metodo para finalizar la lectura
     */

    public synchronized void acabarLectura(){
            lectores--;
            if(lectores == 0){ notifyAll(); }
    }

    /**
     * metodo para iniciar la escritura
     */

    public synchronized void iniciaEscritura(){
            while (lectores != 0 || escribiendo) { try { wait(); } catch (InterruptedException e) {e.printStackTrace();} }
            escribiendo = true;
    }

    /**
     * metodo para finalizar la escritura
     */

    public synchronized void acabarEscritura(){
            escribiendo = false;
            notifyAll();
    }

}