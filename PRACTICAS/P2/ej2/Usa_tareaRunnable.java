package ej2;
public class Usa_tareaRunnable {

    public static void main(String[] args) throws Exception
    {
        
        tareaRunnable r1 = new tareaRunnable(999999999 , 0);
        tareaRunnable r2 = new tareaRunnable(999999999, 1);
        Thread h1 = new Thread(r1);
        Thread h2 = new Thread(r2);
        h1.start();
        h2.start();
        h1.join();
        h2.join ();
        System.out.println(r1.n_());
    }
}
