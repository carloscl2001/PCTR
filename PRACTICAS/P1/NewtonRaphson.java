import java.util.Scanner;

public class NewtonRaphson {
    
    public static double f(double x){
        return Math.cos(x) - Math.pow(x,3);
    }

    public static double fd(double x){
        return -Math.sin(x) - 3*Math.pow(x,2);
    }
    
    public static double g(double x){
        return Math.pow(x,2) - 5;
    }

    public static double gd(double x){
        return 2*x;
    }
    
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        System.out.print("Introduce la funcion(1 o 2) -> ");
        int fun = s.nextInt();

        System.out.print("Introduce la aproximaion inicial -> ");
        double aprox = s.nextDouble();

        System.out.print("Introduce el numero de interaciones que desees.... -> ");
        int interac = s.nextInt();

        double xn = aprox;
        double xn1 = 0;

        if(fun == 1 && aprox > 0 && aprox < 1){

            for(int i = 0; i < interac; i++){
                xn1 = xn - f(xn) / fd(xn);
    
                System.out.println("Iteracion numero: " + i + " | Aproximacion: " + xn);
    
                xn = xn1;

                System.out.println("Resultado: " + xn);
            }            
        }else if(fun == 2 && aprox > 2 && aprox < 3){
            
            for(int i = 0; i < interac; i++){
                xn1 = xn - g(xn) / gd(xn);
    
                System.out.println("Iteracion numero: " + i + " | Aproximacion: " + xn);
    
                xn = xn1;

                System.out.println("Resultado: " + xn);
            }
        }else{
            System.out.println("No valido");
        }

        s.close();
    }
}
