/**
 * Clase que define el monitor
 * @author Carlos A. Cortés Lora
 */
public class lectorEscritor {

    /**
     * Numero de lectores
     */
    public int lectores;

    /**
     * Variable que indica si se esta escribiendo
     */
    public boolean escribiendo;

    /**
     * Recurso compartido
     */
    private recurso recurso;

    /**
     * Constructor de la clase
     */
    public lectorEscritor(){
        lectores = 0;
        escribiendo = false;
        recurso = new recurso();
    }

    /**
     * Metodo para iniciar la lectura
     */
    public synchronized void iniciaLectura(){
        if(escribiendo){
            try{
               wait();
            }catch(InterruptedException e){}
        }
        notifyAll();
    }
    
    
    /**
     * Metodo para acabar la lectura
     */
    public synchronized void acabarLectura(){
        lectores--;
        if(lectores == 0){
            notifyAll();
        }
    }

    /**
     * Metodo para iniciar la escritura
     */
    public synchronized void iniciaEscritura(){
        if(lectores > 0 || escribiendo){
            try{
                wait();
            }catch(InterruptedException e){}
        }
        escribiendo = true;
    }

    /**
     * Metodo para acabar la escritura
     */
    public synchronized void acabarEscritura(){
        escribiendo = false;
        notifyAll();
    }
}
