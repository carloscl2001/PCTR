/**
 * Clase para realizar el producto de una matriz por un vector de manera concurrente
 * @author Carlos Antonio Cortés Lora
 * @version concurrente
 */
public class matVectorConcurrente implements Runnable{
    
    //Variables estáticas
    public static int n = 2;
    public static int m[][] = new int[n][n];
    public static int v[] = new int[n];
    public static int r[] = new int[n];

    //Atributo
    public  int idHebra;

    /**
     * Constructor de la clase
     * @param idHebra identificador de la hebra
     */
    public matVectorConcurrente(int idHebra){
        this.idHebra = idHebra;
    }

    /**
     * Funcion para rellenar una matriz con numeros aleatorios
     * @param m matriz a rellenar
    */
    public static void rellenarMatriz(int m[][]){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (int)(Math.random()*10);
            }
        }
    }

    /**
     * Funcion para rellenar un vector con numeros aleatorios
     * @param v vector a rellenar
     */
    public static void rellenarVector(int v[]){
        for (int i = 0; i < v.length; i++) {
            v[i] = (int)(Math.random()*10);
        }
    }

    /**
     * Imprimir por pantalla una matriz
     * @param m matriz a imprimir
     */
    public static void imprimirMatriz(int m[][]){
        System.out.println("Matriz: ");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Imprimir por pantalla un vector
     * @param v vector a imprimir
     */
    public static void imprimirVector(int v[]){
        System.out.println("Vector: ");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

    /**
     * Sobrecarga de metodo run
     */
    @Override
    public void run(){
        for(int i = 0; i < n; i++){
            r[idHebra] = r[idHebra] + m[idHebra][i] * v[i];
        }
    }


    /**
     * Main del ejercicio de la version multihilo
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        rellenarMatriz(m);
        rellenarVector(v);

        imprimirMatriz(m);
        System.out.println("\n");
        imprimirVector(v);
        
        matVectorConcurrente m1 = new matVectorConcurrente(0);
        matVectorConcurrente m2 = new matVectorConcurrente(1);

        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("\n\tRESULTADO ");
        imprimirVector(r);
    }
}
