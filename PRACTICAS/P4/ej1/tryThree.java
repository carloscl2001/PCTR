import java.security.spec.EdECPoint;
import java.util.*;

public class tryThree {
    
    public static boolean wantp = false;
    public static boolean wantq = false;

    
    /**
     * 
     */
    class p extends Thread {
        public void run() {
            this.getName();
            System.out.println(this.getName());
            while(true) {
                //non-critical section
                wantp = true;
                while(wantq == false);   
                System.out.println(this.getName());           
                wantp = false;
            }
        }
    }

    class q extends Thread {
        public void run() {
            this.getName();
            while(true) {
                //non-critical section
                wantq = true;
                while(wantp == false);
                System.out.println(this.getName());  
                wantq = false;
            }
        }
    }
    
    public tryThree() throws Exception{
        System.out.println("Starting...");
        Thread p1 = new p();
        Thread q1 = new q();

        p1.start();
        q1.start();

        p1.join();
        q1.join();
    }
        

    public static void main(String[] args) throws Exception {
        new tryThree();
    }

}