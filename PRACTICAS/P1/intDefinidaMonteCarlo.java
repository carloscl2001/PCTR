import java.util.*;


public class intDefinidaMonteCarlo{
    
    public static double f(double x){
		return Math.sin(x);
	}
	
	public static double g(double x){
		return x;
	}
    
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        System.out.print("Introduce la funcion a usar(0 o 1)-> ");
        int funcion = s.nextInt();

        System.out.print("Introduce el numero de puntos-> ");
        int puntos = s.nextInt();

        double cont_exito = 0;

        if(funcion == 0){
            for(int i = 0; i < puntos; i++){
                double x = Math.random();
                double y = Math.random();

                if(y <= f(x) ){cont_exito++;}     
            }
            System.out.println("Integral aproximada f(x) = sin ->" + (cont_exito/puntos));
        }

        if(funcion == 1){
            for(int i = 0; i < puntos; i++){
                double x = Math.random();
                double y = Math.random();

                if(y <= g(x) ){cont_exito++;}     
            }
            System.out.println("Integral aproximada g(x) = x -> " + (cont_exito/puntos));

        }

        s.close();
		
        
    }
}
                        