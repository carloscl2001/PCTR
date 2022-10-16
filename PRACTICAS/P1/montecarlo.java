import java.util.*;

public class montecarlo {
    public static void main(String[] args){
        System.out.println("Introduce el numero de puntos a generar");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double cont_exito = 0;
        Random  r = new Random();
        for(int i = 0; i < n; i++)
        {
            int coordenada_x = 0;
            int coordenada_y = 0;

            coordenada_x = r.nextInt(0,1);
            coordenada_y = r.nextInt(0,1);

            if(coordenada_y <= coordenada_x)
            {
                cont_exito += 1;
            }
        }
        System.out.println(cont_exito/n);
      }  
}
