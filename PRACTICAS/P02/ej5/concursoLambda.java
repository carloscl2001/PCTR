import java.util.*;

/**
 * Clase para el ejercicio 5
 * @author Carlos Antonio Cortés Lora
 */
public class concursoLambda {
    /**
     * Variable compartida
     */
    public  static int var_critica = 0;
    /**
     * Main que va a producir una condición de concurso sobre {@code var_critica} sin controlar el entrezalado, siendo utilizada por dos hilo de forma simultánea a través de dosfunciones lambda
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws  Exception {

        System.out.println("Para numero de interacciones ->  500 000");
  
        //Funciones lambda
        Runnable r1 = () -> {for(int i = 0; i < 500000; i++) var_critica++;};
        Runnable r2 = () -> {for(int i = 0; i < 500000; i++) var_critica--;};

        Thread h1 = new Thread(r1);
        Thread h2 = new Thread(r2);
        h1.start();
        h2.start();
        h1.join();
        h2.join();

        System.out.println(var_critica);
    }
}