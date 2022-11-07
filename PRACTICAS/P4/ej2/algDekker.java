

public class algDekker {
    static boolean wantp = false;
    static boolean wantq = false;
    static int turn = 1;

    class p extends Thread {
        public void run() {
            while(true) {
                //non-critical section
                wantp = true;
                while(wantq){
                    if(turn == 2){
                        wantp = false;
                        while(turn == 1);
                        wantp = true;
                    }
                    wantp = true;
                }
                Thread.getName();
                turn = 2;
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
                    if(turn == 1){
                        wantq = false;
                        while(turn == 2);
                        wantq = true;
                    }
                    wantq = true;
                }
                Thread.getName();
                turn = 1;
                wantq = false;
            }

        }
    }

    public static void main(String[] args) throws  Exception {
       
        p p = new p();
        q q = new q();
        p.start();
        q.start();

        p.join();
        q.join();

        System.out.println("Hello, World!");
    }
}
