public class ServidorHiloconPool {
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(9999);
            ExecutorService pool = Executors.newFixedThreadPool(10);
            for (;;) {
                Socket cl = s.accept();
                pool.execute(new HiloServidor(cl));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}