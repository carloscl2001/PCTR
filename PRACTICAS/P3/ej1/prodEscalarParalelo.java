public class prodEscalarParalelo extends Thread {

    public int idHebra;
    public int ini;
    public int fin;


    public static int nHebras = 10;
    public static final int potencia = 6;
    public static final int p = 10;
    public static int[] vector1 = new int[(int)Math.pow(p, potencia)];
    public static int[] vector2 = new int[(int)Math.pow(p, potencia)];
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
     * Metodo para rellenar los vectores 
     */
    public static void rellenarVectores(){
        for (int i = 0; i < vector1.length; i++) {
            vector1[i] = i;
            vector2[i] = i;
        }

        for (int i = 0; i < productoParcial.length; i++) {
            productoParcial[i] = 0;
        }
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


    /**
     * Metodo para calcular el resultado final
     */
    public static void obtenerResultado(){
        int resultado = 0;
        for(int i=0; i < productoParcial.length; i++){
            resultado = resultado + productoParcial[i];
        }
        System.out.println("El resultado de la suma es: " + resultado);
    }


    public static void main(String[] args) throws Exception{
        rellenarVectores();

        long startTime = System.nanoTime();

        prodEscalarParalelo hebra1 = new prodEscalarParalelo(0, 0, vector1.length/2);
        prodEscalarParalelo hebra2 = new prodEscalarParalelo(1, vector1.length/2, vector1.length);
 
        
        hebra1.start();
        hebra2.start();

        
        hebra1.join();
        hebra2.join();
 




        long endTime = System.nanoTime();
        obtenerResultado();
        System.out.println("Duración: " + (endTime-startTime)/1e6 + " ms");
    }
}
