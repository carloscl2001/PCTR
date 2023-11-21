public class prodCon {
    
    /**
     * Tamaño del buffer
     */
    private int numSlots = 0;

    /**
     * Buffer de enteros protegido
     */
    private int[] buffer = null;

    /**
     * Posición de inserción del buffer
     */
    private int posInt = 0;

    /**
     * Posición de extracción del buffer
     */
    private int posOut = 0;

    /**
     * Número de elementos en el buffer
     */
    private int cont = 0;

    /**
     * Constructor de la clase
     * @param numSlots
     */
    public prodCon(int numSlots) {
        this.numSlots = numSlots;
        buffer = new int[numSlots];
    }

    /**
     * Método que inserta un entero en el buffer
     * @param valor a insertar en el buffer
     */
    public synchronized void producir(int valor){ 
        //condicion de guarda: ¿Vector está lleno?

        //que el vector este lleno de elementos -> NO PODEMOS PRODUCIMOS -> se manda a la cola
        while (cont == numSlots) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //que el vector tega un hueco libre -> SI PODEMOS PRODUCIR -> no está lleno 
        buffer[posInt] = valor;
        System.out.println("Produciendo item-> " + valor);
        posInt = (posInt + 1) % numSlots;
        cont++;
        notifyAll();
    }

    /**
     * Método que extrae un entero del buffer
     * @return valor del buffer
     */
    public synchronized int consumir(){
        int valor;
        while(cont == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        valor = buffer[posOut];
        buffer[posOut] = valor-valor;
        posOut = (posOut + 1) % numSlots;
        cont--;
        notifyAll();
        return valor;
    }

    public synchronized void mostrar(){
        System.out.println("Buffer: ");
        for (int i = 0; i < buffer.length; i++) {
            System.out.print(buffer[i] + " ");
        }
        System.out.println();
    }       
}
