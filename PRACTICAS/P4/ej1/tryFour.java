
public class tryFour {
    
    static boolean wantp = false;
    static boolean wantq = false;

    class p extends Thread {
        public void run() {
            while(true) {
                //non-critical section
                wantp = true;
                while(wantq){
                    wantp = false;
                    wantp = true;
                }
                Thread.getName();
                wantp = false;
            }
        }
    }

    class q extends Thread {
        public void run() {
            while(true) {
                //non-critical section
                wantq = true;
                while(wantp){
                    wantq = false;
                    wantq = true;
                }
                Thread.getName();
                wantq = false;
            }

        }
    }


    public static void main(String[] args) {

        Thread p = new p();
        Thread q = new q();

        p.start();
        q.start();

        System.out.println("Hello, World!");
    }
}
