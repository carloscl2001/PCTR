import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import ej3.recurso;

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
     * Lock para el monitor
     */
    final ReentrantLock lock;

    /**
     * Variable de condicion para los lectores
     */
    final Condition CondLectores;

    /**
     * Variable de condicion para los escritores
     */
    final Condition CondEscritores;

    /**
     * Constructor de la clase
     */
    public lectorEscritor(){
        lectores = 0;
        escribiendo = false;
        recurso = new recurso();
        lock = new ReentrantLock();
        CondLectores = lock.newCondition();
        CondEscritores = lock.newCondition();
    }

    /**
     * Metodo para iniciar la lectura
     */
    public void iniciaLectura(){
        lock.lock();
        try{
            while(escribiendo){
                try{
                   CondLectores.await();
                }catch(InterruptedException e){}
            }
            CondLectores.signalAll();
        }finally{
            lock.unlock();
        }
        
    }
    
    
    /**
     * Metodo para acabar la lectura
     */
    public void acabarLectura(){
        lock.lock();
        try{
            lectores--;
            while(lectores == 0){
                CondEscritores.signalAll();
            }
        } finally{
            lock.unlock();
        }
        
    }

    /**
     * Metodo para iniciar la escritura
     */
    public void iniciaEscritura(){
        lock.lock();
        try{
            while(lectores > 0 || escribiendo){
                try{
                    CondEscritores.await();
                }catch(InterruptedException e){}
            }
            escribiendo = true;
        } finally{
            lock.unlock();
        }
        
    }

    /**
     * Metodo para acabar la escritura
     */
    public void acabarEscritura(){
        lock.lock();
        try{
            escribiendo = false;
            if(lectores == 0){CondEscritores.signalAll();}
            
            else{CondLectoresCondLectores.signalAll();}
            
        } finally{
            lock.unlock();
        }
        
    }
}
