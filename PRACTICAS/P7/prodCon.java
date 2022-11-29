public class prodCon {
    
    

    private int buffer[];


    public prodCon(int buffer[]){
        this.buffer = buffer;
        for(int i=0; i<buffer.length; i++){
            buffer[i]= 5;
        }
    }


    public synchronized void producir(){ 
        System.out.println("Preparado para producir");
        while(buffer.length != 0){
            try{wait();} 
            catch(InterruptedException e){}
        }
        System.out.println("N-> " + buffer.length);
        buffer.length++;
        System.out.println("N-> " + buffer.length);
        System.out.println("Producido");
        notifyAll();
    }

    public synchronized void consumir(){
        System.out.println("Preparado para consumir");
        while(buffer.length <= 0){
            try{wait();}
            catch(InterruptedException e){}
        }
        System.out.println("N-> " + buffer.length);
        buffer.length--;
        System.out.println("N-> " + buffer.length);
        notifyAll();
        System.out.println("Consumido");
       
    }

    public synchronized void mostrar(){
        System.out.println("N-> " + buffer.length);
        for(int i=0; i<buffer.length; i++){
            System.out.println(buffer[i]);
        }
    }
        
}
