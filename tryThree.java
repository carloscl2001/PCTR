/**
 * tryThree
 */
public class tryThree extends Thread{

    static bool wantp = false;
    static bool wantq = false;
    
    Thread h = new tryThree();
    Thread i = new tryThree();

    public static void main(String[] args) {
        h.start();
        i.start();
    }



    public void run() {
        while(){
            //non-critical section
            wantp = true;
            while(wantq == false){
                //do nothing
            }
            //critical section
            wantp = false;
        }
    };
    

    while(){
        //non-critical section
        wantq = true;
        while(wantp == false){
            //do nothing
        }
        //critical section
        wantq = false;
    }


}