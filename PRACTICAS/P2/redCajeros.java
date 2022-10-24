public class redCajeros {
    
    public static void main(String[] args) throws Exception{
        cuentaCorriente cC = new cuentaCorriente(12345, 0);

        Runnable r1 = new cajero(cC, 25, 1);
        Runnable r2 = new cajero(cC, 25, 2);
    
        Thread h1 = new Thread(r1);
        Thread h2 = new Thread(r2);

        h1.start();
        h2.start();
        
        h1.join();
        h2.join();
        
        cC.saldo();
    }
}
