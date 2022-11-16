/**
 * Clase para hallar los numeros perfectos en un rango de forma secuencial
 * @author Carlos Antonio Cortés Lora
 * @version concurrente
 */
public class numPerfectos {

    /**
     * Funcion para comprobar si un numero es perfecto
     * @param n numero a comprobar
     * @return true si es perfecto, false en caso contrario
     */
    static boolean esPerfecto(long n) {
        long suma = 0;

        for (long i = 1; i < n; ++i){if (n % i == 0) suma += i;}
            
        if (n == suma){return (true);}
        else{return (false);}
    }

    /**
     * Main para calcular los numeros perfectos en un rango
     * @param args intervalo rango
     * @return numero de numeros perfectos
     */
    public static void main(String[] args) {
        long intervalo = Long.parseLong(args[0]);

        int total = 0;
        
        long inicTiempo = System.nanoTime();
        for(long i=1; i<=intervalo;i++){
            if(esPerfecto(i)){
                total++;
                System.out.println(i);
            }
        }
        System.out.println("Perfectos encontrados -> " + total);
        float tiempoTotal = (System.nanoTime()-inicTiempo)/(float)1.0e9;
        System.out.println("Encontrados  en " + tiempoTotal + " segundos");
    }   
}
