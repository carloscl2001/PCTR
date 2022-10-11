import java.util.Scanner;//es para usar la clase Scanner de la bibilioteca util
import java.util.*;// es para poder usar todas las funciones de la biblioteca util

public class nAleatorio {
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    int     n = s.nextInt();
    Random  r = new Random();
    for(int i=0; i<n; i++)
      System.out.println(r.nextFloat());
    for(int i=0; i<n; i++)
      System.out.println(r.nextInt());    
    for(int i=0; i<n; i++)	 	 		     		System.out.println(r.nextBoolean());
    for(int i=0; i<n; i++){
      System.out.println(r.nextGaussian());
    }
  }  
}
