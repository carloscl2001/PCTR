import java.util.Scanner;

public class ej1 {
    
    public static double f(double x){
        return Math.cos(x) - Math.pow(x,3);
    }

    public static double fd(double x){
        return -Math.sin(x) - 3*Math.pow(x,2);
    }
    
    
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        System.out.print("Introdue la aproximaion inicial -> ");
        double aprox = s.nextDouble();
        System.out.print("Introdue el numero de interaciones que desees.... -> ");
        int interac = s.nextInt();

        double xn = aprox;
        double xn1 = 0;

        for(int i = 0; i < interac; i++){
            xn1 = xn - f(xn) / fd(xn);

            System.out.println("Iteracion numero: " + i + " | Aproximacion: " + xn);

            xn = xn1;
        }
        
        System.out.println("Resultado: " + xn);

        s.close();
    }
}
