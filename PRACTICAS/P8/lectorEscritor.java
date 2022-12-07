/**
 * Clase que define el monitor que incorpora acceso seguro al buffer
 */
public class lectorEscritor {

    int lectores;
    boolean escribiendo;

    public lectorEscritor(){}

    /**
     * Metodo para producir el buffer
     */
    public synchronized void iniciaLectura(){
        if(escribiendo){
           try{
               wait();
           }catch(InterruptedException e){

           }
        }
        lectores++;
        notify();
    }
    
    
    /**
     * Metodo para consumir el buffer
     */
    public synchronized void acabarLectura(){
        lectores--;
        if(lectores == 0){
            notify();
        }
    }

    /**
     * Metodo que imprime el buffer por pantalla
     */
    public synchronized void mostrarBuffer(){
        for(int i=0; i<N; i++){
            System.out.println(buffer[i]);
        }
    }
}
