public class prodEscalarParalelo extends Thread {

    public int idHebra;
    public int ini;
    public int fin;


    public static int nHebras = 4;
    public static final int potencia = 1;
    public static int[] vector1 = new int[(int)Math.pow(8, potencia)];
    public static int[] vector2 = new int[(int)Math.pow(8, potencia)];
    public static int[] productoParcial = new int[nHebras];

    /**
     * Constructor de la clase
     * @param idHebra
     * @param ini
     * @param fin
     */
    public prodEscalarParalelo(int idHebra, int ini, int fin) {
        this.idHebra = idHebra;
        this.ini = ini;
        this.fin = fin;
    }


    /**
     * Metodo para rellenar los vectores con numeros aleatorios
     */
    public static void rellenarVectores(){
        for (int i = 0; i < vector1.length; i++) {
            vector1[i] = (int) (Math.random() * 10);
            vector2[i] = (int) (Math.random() * 10);
        }

        for (int i = 0; i < productoParcial.length; i++) {
            productoParcial[i] = 0;
        }
    }
    

    /**
     * Funcion para imprimir por pantalla los vectores
     */
    public static void imprimirVectores() {
        System.out.print("Vector 1: ");
        for (int i = 0; i < vector1.length; i++) {
            System.out.print(vector1[i] + " ");
        }
        System.out.println();
        System.out.print("Vector 2: ");
        for (int i = 0; i < vector2.length; i++) {
            System.out.print(vector2[i] + " ");
        }
        System.out.println();
        
        System.out.print("Vector Resultado: ");
        for (int i = 0; i < productoParcial.length; i++) {
            System.out.print(productoParcial[i] + " ");
        }
        System.out.println();
        
    }

    
    /**
     * Sobrecarga del metodo run
     */
    public void run() {
        for (int i = ini; i < fin; i++) {
            if(i == ini){
                productoParcial[idHebra] = (vector1[i] * vector2[i]);
            }else{
                productoParcial[idHebra] = (vector1[i] * vector2[i]) + productoParcial[idHebra];
            }
        }
    }
    
    public static void obtenerResultado(){
        int resultado = 0;
        for(int i=0; i < productoParcial.length; i++){
            resultado = resultado + productoParcial[i];
        }
        System.out.println("El resultado de la suma es: " + resultado);

    }

    public static void main(String[] args) throws Exception{
        rellenarVectores();

        prodEscalarParalelo hebra1 = new prodEscalarParalelo(0, 0, vector1.length/4);
        prodEscalarParalelo hebra2 = new prodEscalarParalelo(1, vector1.length/4, vector1.length/2);
        prodEscalarParalelo hebra3 = new prodEscalarParalelo(2, vector1.length/2, 3*(vector1.length/4));
        prodEscalarParalelo hebra4 = new prodEscalarParalelo(3, vector1.length*3/4, vector1.length);

        hebra1.start();
        hebra2.start();
        hebra3.start();
        hebra4.start();

        hebra1.join();
        hebra2.join();
        hebra3.join();
        hebra4.join();
        
        imprimirVectores();
        obtenerResultado();
    }
}
