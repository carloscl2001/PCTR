/**
 * tryThree
 */
public class tryThree {

    public static bool wantp = false;
    public static bool wantq = false;
    

    class p extends Thread {
        public void run() {
            while(true) {
                //non-critical section
                wantp = true;
                while(wantq == false){
                    //do nothing
                }
                //critical section
                wantp = false;
            }
        }
    }

    class q extends Thread {
        public void run() {
            while(true) {
                //non-critical section
                wantq = true;
                while(wantp == false){
                    //do nothing
                }
                //critical section
                wantq = false;
            }

        }
    }

    
    public static void main(String[] args) throws Exception {
        Thread p = new p();
        Thread q = new q();

        p.start();
        q.start();

    }


}