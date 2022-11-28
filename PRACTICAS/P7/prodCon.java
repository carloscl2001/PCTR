/**
 * Clase que define el monitor que incorpora acceso seguro al buffer
 */
public class prodCon {

    private int buffer[] = new int[50];

    public synchronized void incBuffer(){
       for(int i=0; i<50; i++){
           buffer[i]++;
       }
    }
    
    public synchronized void decBuffer(){
        for(int i=0; i<50; i++){
            buffer[i]--;
        }
    }

    public synchronized void mostrarBuffer(){
        for(int i=0; i<50; i++){
            System.out.println(buffer[i]);
        }
    }
}
