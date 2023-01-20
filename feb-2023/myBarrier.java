import java.util.*;

/**
 * @author Carlos Antonio Cortés Lora
 * @author 77496883Q
 * 
 * Clase que se usa para crear myBarrier
 */
class myBarrier{

    public int s;

    public boolean flag = false;

    public myBarrier(int numThreads, boolean flag){
        this.s = numThreads;
        this.flag = flag;
    }

    public synchronized void toWaitOnBarier() throws Exception{
        boolean flag = false;
        for(int i = 0; i < s; i++){
            while(s==0)try{wait();}catch(InterruptedException e){}
            if(s == 0){
                this.flag = true;
            }
            s=s-1;
        }
        if(flag == true){
            notifyAll();
        }
        
    }

    public synchronized void resetBarrier(){
        this.flag = false;
        this.s = 3;
    }
}