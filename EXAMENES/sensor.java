/**
 * sensor
 */
import java.util.Scanner;
import java.util.Random;

public class sensor extends Thread {
    //tamano de las senales
    public static int N = 0;
    //numero de hebras
    public static int numHebras;

    //senales de entrada Zeta 
    public static int[] senalEntradaZeta;
    //senales de entrada Rho
    public static int[] senalEntradaRho;
    //senales de salida Xi
    public static int[] senalSalidaXi;

    public void run() {
        // senalSalidaXi[i] = senalEntradaZeta[i];
        // if(i == 0 || i == N-1){

        // }
        //  + senalEntradaZeta[i+1];
    };

    public static void incializarSenales(int N) {
        senalEntradaZeta = new int[N];
        senalEntradaRho = new int[N];
        senalSalidaXi = new int[N];
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Opcion 1 -> Manual");
        System.out.println("Opcion 2 -> Automatico");
        System.out.print("Elige una opcion: ");
        Scanner teclado = new Scanner(System.in);
        int opcion = teclado.nextInt();
        if(opcion == 1){
            System.out.print("Introduce el tamano de las senales N: ");
            N = teclado.nextInt();
            incializarSenales(N);
            System.out.print("Introduce los valores de Zeta ->");
            for (int i = 0; i < N; i++) {
                senalEntradaZeta[i] = teclado.nextInt();
            }
            System.out.println("Introduce los valores de Rho ->");
            for (int i = 0; i < N; i++) {
                senalEntradaRho[i] = teclado.nextInt();
            }
            System.out.print("Introduce el numero de hebras: ");
            
            System.out.println("Senal de entrada Zeta: ");
            for (int i = 0; i < N; i++) {
                System.out.print(senalEntradaZeta[i] + " ");
            }
            System.out.println();
            System.out.println("Senal de entrada Rho: ");
            for (int i = 0; i < N; i++) {
                System.out.print(senalEntradaRho[i] + " ");
            }
            System.out.println();
            System.out.println("Senal de salida Xi: ");
            for (int i = 0; i < N; i++) {
                System.out.print(senalSalidaXi[i] + " ");
            }
        }else{

        }
        

    }
}